
using KSL_API.DAL;
using KSL_API.DTO.Profissional;
using KSL_API.Mapper;
using Microsoft.AspNetCore.Mvc;

namespace KSL.Controllers;

[Route("api/profissional")]
[ApiController]
public class ProfissionalController: ControllerBase
{
    private readonly AppDbContext _context;
    
    public ProfissionalController(AppDbContext context )
    {
        _context = context;
    }

    [HttpGet]
    public IActionResult GetAll()
    {
        var profissional = _context.Profissional.ToList();
        return Ok(profissional);
    }
    
    [HttpGet("{id}")]
    public IActionResult GetById([FromRoute] int id)
    {
        var profissional = _context.Profissional.Find(id);
        if (profissional == null)
        {
            return NotFound();
        }
        return Ok(profissional);
    }
    
    [HttpPost] 
    public IActionResult Create([FromBody] CreateProfissionalDTO profissional_DTO)
    {
        var profissionalModel = profissional_DTO.ToProfissionalFromCreatedDTO();
        _context.Profissional.Add(profissionalModel);
        _context.SaveChanges();
        return (CreatedAtAction(nameof(GetById), new { IdProfissional = profissionalModel.IdProfissional },
            profissionalModel));
    }
}