using DTO.Cliente;
using Microsoft.AspNetCore.Mvc;
using Shared.Service;

namespace karapinhaApi.Controllers;

[Route("api/clientes")]
[ApiController]
public class ClienteController: ControllerBase
{
    private readonly IClienteService _clienteService;

    public ClienteController(IClienteService clienteService)
    {
        _clienteService = clienteService;
    }
    
    [HttpGet]
    public async Task<IActionResult> GetClientes()
    {
        var clienteDto = await _clienteService.GetClientesAsync();
        return Ok(clienteDto);
    }
    
    [HttpGet]
    [Route(("{id:int}"))]
    public async Task<IActionResult> GetCliente([FromRoute] int id)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(ModelState);
        }
        
        var cliente = await _clienteService.GetClienteAsync(id);
        if (cliente == null)
        {
            return NotFound();
        }

        return Ok(cliente);
    }
    
    [HttpPost]
    public async Task<IActionResult> CreateCliente([FromBody] CreateClienteRequestDto clienteRequestDto)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(ModelState);
        }

        var cliente = await _clienteService.CreateClienteAsync(clienteRequestDto);
        return CreatedAtAction(nameof(GetCliente), new { id = cliente.IdCliente }, cliente);
    }

    [HttpPut]
    [Route(("{id:int}"))]
    public async Task<IActionResult> UpdateCliente([FromRoute] int id, [FromBody] UpdateClienteRequestDto updateClienteRequestDto)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(ModelState);
        }

        var cliente = await _clienteService.UpdateClienteAsync(id, updateClienteRequestDto);
        if (cliente == null)
        {
            return NotFound();
        }

        return Ok(cliente);
    }
    
    [HttpDelete]
    [Route("{id:int}")]
    public async Task<IActionResult> DeleteCliente([FromRoute] int id)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(ModelState);
        }

        var cliente = await _clienteService.DeleteClienteAsync(id);
        if (cliente == null)
        {
            return NotFound();
        }

        return NoContent();
        
    }
}