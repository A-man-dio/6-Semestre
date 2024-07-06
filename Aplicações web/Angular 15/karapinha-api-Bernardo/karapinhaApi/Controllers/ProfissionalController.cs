using Microsoft.AspNetCore.Mvc;
using DTO.Profissional;
using Shared.Service;

namespace karapinhaApi.Controllers;

[Route("api/profissionals")]
[ApiController]
public class ProfissionalController: ControllerBase
{
    private readonly IProfissionalService _profissionalService;
    
    public ProfissionalController(IProfissionalService profissionalService)
    {
        _profissionalService = profissionalService;
    }

    [HttpGet]
    public async Task<IActionResult> GetProfissionals()
    {
        var profissionalDto = await _profissionalService.GetProfissionalsAsync();
        return Ok(profissionalDto);
    }
    
    [HttpGet]
    [Route(("{id:int}"))]
    public async Task<IActionResult> GetProfissional([FromRoute] int id)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(ModelState);
        }
        
        var profissional = await _profissionalService.GetProfissionalAsync(id);
        if (profissional == null)
        {
            return NotFound();
        }

        return Ok(profissional);
    }
    
    [HttpPost]
    public async Task<IActionResult> CreateProfissional([FromBody] CreateProfissionalRequestDto profissionalRequestDto)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(ModelState);
        }

        var profissional = await _profissionalService.CreateProfissionalAsync(profissionalRequestDto);
        return CreatedAtAction(nameof(GetProfissional), new { id = profissional.IdProfissional }, profissional);
    }

    [HttpPut]
    [Route(("{id:int}"))]
    public async Task<IActionResult> UpdateProfissional([FromRoute] int id, [FromBody] UpdateProfissionalRequestDto updateProfissionalRequestDto)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(ModelState);
        }

        var profissional = await _profissionalService.UpdateProfissionalAsync(id, updateProfissionalRequestDto);
        if (profissional == null)
        {
            return NotFound();
        }

        return Ok(profissional);
    }
    
    [HttpDelete]
    [Route("{id:int}")]
    public async Task<IActionResult> DeleteProfissional([FromRoute] int id)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(ModelState);
        }

        var profissional = await _profissionalService.DeleteProfissionalAsync(id);
        if (profissional == null)
        {
            return NotFound();
        }

        return NoContent();
        
    }
}