using KSL_API.DTO.Categoria;
using KSL_API.Models;

namespace KSL_API.Mapper;

public static class CategoriaMapper
{
    public static Categoria ToCategoriaFromCreatedDTO(this CreateCategoriaDTO categoriaDTO)
    {
        return new Categoria
        {
            Nome = categoriaDTO.Nome
        };
    }   
}