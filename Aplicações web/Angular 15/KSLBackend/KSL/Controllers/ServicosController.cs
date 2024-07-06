using KSL_API.DAL;
using KSL_API.DTO.Servico;
using KSL_API.Mapper;
using Microsoft.AspNetCore.Mvc;

namespace KSL.Controllers;
[Route("api/servico")]
[ApiController]
public class ServicosController : ControllerBase
{
    private readonly AppDbContext _context;
    public ServicosController(AppDbContext context )
    {
        _context = context;
    }

    [HttpGet]
    public IActionResult GetAll()
    {
        var servicos = _context.Servico.ToList();
        return Ok(servicos);
    }
    
    [HttpGet("{id}")]
    public IActionResult GetById([FromRoute] int id)
    {
        var servico = _context.Servico.Find(id);
        if (servico == null)
        {
            return NotFound();
        }
        return Ok(servico);
    }
    
    [HttpPost] 
    public IActionResult Create([FromBody] CreateServicoDTO servico_DTO)
    {
        var servicoModel = servico_DTO.ToServicoFromCreatedDTO();
        _context.Servico.Add(servicoModel);
        _context.SaveChanges();
        return (CreatedAtAction(nameof(GetById), new { IdServico = servicoModel.IdServico },
            servicoModel));
    }
    
    
}