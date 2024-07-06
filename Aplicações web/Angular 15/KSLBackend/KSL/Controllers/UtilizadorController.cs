using KSL_API.DAL;
using KSL_API.DTO.Utilizador;
using KSL_API.Mapper;
using Microsoft.AspNetCore.Mvc;

namespace KSL.Controllers;

[Route("api/utilizador")]
[ApiController]
public class UtilizadorController : ControllerBase
{
    
    private readonly AppDbContext _context;
    
    public UtilizadorController(AppDbContext context )
    {
        _context = context;
    }

    [HttpGet]
    public IActionResult GetAll()
    {
        var utilizador = _context.Utilizador.ToList()
            .Select(s => s.ToUtilizadorDto());
        return Ok(utilizador);
    }
    
    [HttpGet("{id}")]
    public IActionResult GetById([FromRoute] int id)
    {
        var utilizador = _context.Utilizador.Find(id);
        if (utilizador == null)
        {
            return NotFound();
        }
        return Ok(utilizador.ToUtilizadorDto());
    }

    [HttpPost] //recebe do front e manda para a BD
    public IActionResult Create([FromBody] CreateUtilizadorDTO Utilizador_DTO)
    {
        var utilizadorModel = Utilizador_DTO.ToUtilizadorFromCreatedDTO();
        _context.Utilizador.Add(utilizadorModel);
        _context.SaveChanges();
        return (CreatedAtAction(nameof(GetById), new { IdUtilizador = utilizadorModel.IdUtilizador },
            utilizadorModel.ToUtilizadorDto()));
    }
}