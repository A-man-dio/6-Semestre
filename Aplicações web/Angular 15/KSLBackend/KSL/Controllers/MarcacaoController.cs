using KSL_API.DAL;
using KSL_API.DTO.Marcacao;
using KSL_API.Mapper;
using Microsoft.AspNetCore.Mvc;
namespace KSL.Controllers;
[Route("api/marcacao")]
[ApiController]

public class MarcacaoController : ControllerBase
{
    private readonly AppDbContext _context;
    
    public MarcacaoController(AppDbContext context )
    {
        _context = context;
    }

    [HttpGet]
    public IActionResult GetAll()
    {
        var marcacao = _context.Marcacao.ToList();
        return Ok(marcacao);
    }
    
    [HttpGet("{id}")]
    public IActionResult GetById([FromRoute] int id)
    {
        var marcacao = _context.Marcacao.Find(id);
        if (marcacao == null)
        {
            return NotFound();
        }
        return Ok(marcacao);
    }
    
    [HttpPost] 
    public IActionResult Create([FromBody] CreateMarcacaoDTO marcacao_DTO)
    {
        var marcacaoModel = marcacao_DTO.ToMarcacaoFromCreatedDTO();
        _context.Marcacao.Add(marcacaoModel);
        _context.SaveChanges();
        return (CreatedAtAction(nameof(GetById), new { Id = marcacaoModel.IdMarcacao },
            marcacaoModel));
    }
}