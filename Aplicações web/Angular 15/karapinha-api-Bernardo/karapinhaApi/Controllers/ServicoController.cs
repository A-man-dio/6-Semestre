using DTO.Servico;
using Microsoft.AspNetCore.Mvc;
using Shared.Service;

namespace karapinhaApi.Controllers;

[Route("api/servicos")]
[ApiController]
public class ServicoController: ControllerBase
{

    private readonly IServicosService _servicosService;
    public ServicoController(IServicosService servicosService)
    {
        _servicosService = servicosService;
    }

    [HttpGet]
    public async Task<IActionResult> GetServicos()
    {
        var servicosDto = await _servicosService.GetServicosAsync();
        return Ok(servicosDto);
    }
    
    [HttpGet]
    [Route(("{id:int}"))]
    public async Task<IActionResult> GetServico([FromRoute] int id)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(ModelState);
        }
        
        var servico = await _servicosService.GetServicoAsync(id);
        if (servico == null)
        {
            return NotFound();
        }

        return Ok(servico);
    }
    
    [HttpPost]
    public async Task<IActionResult> CreateServicos([FromBody] CreateServicoRequestDto servicoRequestDto)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(ModelState);
        }

        var servico = await _servicosService.CreateServicoAsync(servicoRequestDto);
        return CreatedAtAction(nameof(GetServico), new { id = servico.IdServico }, servico);
    }

    [HttpPut]
    [Route(("{id:int}"))]
    public async Task<IActionResult> UpdateServicos([FromRoute] int id, [FromBody] UpdateServicoRequestDto updateServicoRequestDto)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(ModelState);
        }

        var servico = await _servicosService.UpdateServicoAsync(id, updateServicoRequestDto);
        if (servico == null)
        {
            return NotFound();
        }

        return Ok(servico);
    }
    
    [HttpDelete]
    [Route("{id:int}")]
    public async Task<IActionResult> DeleteServicos([FromRoute] int id)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(ModelState);
        }

        var servico = await _servicosService.DeleteServicoAsync(id);
        if (servico == null)
        {
            return NotFound();
        }

        return NoContent();
        
    }
}