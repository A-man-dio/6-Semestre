using KSL_API.DAL;
using KSL_API.DTO.Categoria;
using KSL_API.Mapper;
using Microsoft.AspNetCore.Mvc;

namespace KSL.Controllers;

[Route("api/categoria")]
[ApiController]

public class CategoriaController : ControllerBase
{
    private readonly AppDbContext _context;
    
    public CategoriaController(AppDbContext context )
    {
        _context = context;
    }

    [HttpGet] //recebe da BD e manda para o front 
    public IActionResult GetAll() 
    {
        var categoria = _context.Categoria.ToList();
        return Ok(categoria);
    }
    
    [HttpGet("{id}")]
    public IActionResult GetById([FromRoute] int id)
    {
        var categoria = _context.Categoria.Find(id);
        if (categoria == null)
        {
            return NotFound();
        }
        return Ok(categoria);
    }
    [HttpPost] 
    public IActionResult Create([FromBody] CreateCategoriaDTO categoria_DTO)
    {
        var categoriaModel = categoria_DTO.ToCategoriaFromCreatedDTO();
        _context.Categoria.Add(categoriaModel);
        _context.SaveChanges();
        return (CreatedAtAction(nameof(GetById), new { IdCategoria = categoriaModel.IdCategoria },
            categoriaModel));
    } 
}