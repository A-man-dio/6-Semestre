using KSL_API.DTO.Utilizador;
using KSL_API.Models;

namespace KSL_API.Mapper;

public static class Utilizador_Mapper
{
    public static Utilizador_DTO ToUtilizadorDto(this Utilizador UtilizadorModel )
    {
        return new Utilizador_DTO
        {
            IdUtilizador = UtilizadorModel.IdUtilizador,
            Email = UtilizadorModel.Email,
            NomeCompleto = UtilizadorModel.NomeCompleto,
            Telemovel = UtilizadorModel.Telemovel,
            Foto = UtilizadorModel.Foto,
            Username = UtilizadorModel.Username,
            BI = UtilizadorModel.BI
        };
    }

    public static Utilizador ToUtilizadorFromCreatedDTO(this CreateUtilizadorDTO UtilizadorDTO)
    {
        return new Utilizador
        {
            Email = UtilizadorDTO.Email,
            NomeCompleto = UtilizadorDTO.NomeCompleto,
            Telemovel = UtilizadorDTO.Telemovel,
            Username = UtilizadorDTO.Username,
            BI = UtilizadorDTO.BI,
            Password = UtilizadorDTO.Password
        };
    }
}