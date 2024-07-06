using DTO.Cliente;
using Model;

namespace Shared.Repository;

public interface IClienteRepository
{
    Task<List<ClienteDto>> GetClientesAsync();
    Task<ClienteDto?> GetClienteAsync(int id);
    Task<ClienteDto> CreateClienteAsync(Cliente clienteModel);
    Task<ClienteDto?> UpdateClienteAsync(int id, UpdateClienteRequestDto clienteRequestDto);
    Task<Cliente?> DeleteClienteAsync(int id);
}