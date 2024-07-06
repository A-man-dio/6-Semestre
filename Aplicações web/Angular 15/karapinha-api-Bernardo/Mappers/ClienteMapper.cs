using Model;
using DTO.Cliente;
namespace Mappers;

public static class ClienteMapper
{
    public static ClienteDto ToClienteDto(this Cliente clienteModel)
    {
        return new ClienteDto()
        {
            IdCliente = clienteModel.IdCliente,
            Nome = clienteModel.Nome,
            Email = clienteModel.Email,
            Telemovel = clienteModel.Telemovel,
            Bi = clienteModel.Bi,
            Foto = clienteModel.Foto,
            Estado = clienteModel.Estado,
            UpdatedOn = clienteModel.UpdatedOn,
            CreatedOn = clienteModel.CreatedOn,
            Username = clienteModel.Username,
            Password = clienteModel.Password,
            
        };
    }
    
    public static Cliente ToCreateCliente(this CreateClienteRequestDto clienteModel)
    {
        return new Cliente()
        {
            Nome = clienteModel.Nome,
            Email = clienteModel.Email,
            Telemovel = clienteModel.Telemovel,
            Bi = clienteModel.Bi,
            Username = clienteModel.Username,
            Password = clienteModel.Password,
            Foto = clienteModel.Foto,
        };
    }
}