using DTO.Cliente;
using Mappers;
using Microsoft.EntityFrameworkCore;
using Model;
using Shared.Repository;

namespace DAL.Repositories;

public class ClienteRepository: IClienteRepository
{
    private readonly AppDbContext _context;

    public ClienteRepository(AppDbContext context)
    {
        _context = context;
    }
    
    
    public async Task<List<ClienteDto>> GetClientesAsync()
    {
        return await _context.Clientes.Select(cliente => cliente.ToClienteDto()).ToListAsync();
    }

    public async Task<ClienteDto?> GetClienteAsync(int id)
    {
        return await _context.Clientes.Where(cliente => cliente.IdCliente == id).Select(cliente => cliente.ToClienteDto()).FirstOrDefaultAsync();
    }

    public async Task<ClienteDto> CreateClienteAsync(Cliente clienteModel)
    {
        await _context.Clientes.AddAsync(clienteModel);
        await _context.SaveChangesAsync();
        return clienteModel.ToClienteDto();
    }

    public async Task<ClienteDto?> UpdateClienteAsync(int id, UpdateClienteRequestDto updateClienteRequestDto)
    {
        var existingCliente = await _context.Clientes.FirstOrDefaultAsync(cliente => cliente.IdCliente == id);
        if (existingCliente == null) return null;

        existingCliente.Nome = updateClienteRequestDto.Nome;
        existingCliente.Telemovel = updateClienteRequestDto.Telemovel;
        existingCliente.Estado = updateClienteRequestDto.Estado;
        existingCliente.Bi = updateClienteRequestDto.Bi;
        existingCliente.Email = updateClienteRequestDto.Email;
        existingCliente.Username = updateClienteRequestDto.Username;
        existingCliente.Password = updateClienteRequestDto.Password;
        //existingCliente.Foto = updateClienteRequestDto.Foto;
        existingCliente.UpdatedOn = DateTime.Now;

        await _context.SaveChangesAsync();
        return existingCliente.ToClienteDto();
    }

    public async Task<Cliente?> DeleteClienteAsync(int id)
    {
        var existingCliente = await _context.Clientes.FirstOrDefaultAsync(cliente => cliente.IdCliente == id);
        if (existingCliente == null) return null;
        _context.Clientes.Remove(existingCliente);
        await _context.SaveChangesAsync();
        return existingCliente;
    }
    
}