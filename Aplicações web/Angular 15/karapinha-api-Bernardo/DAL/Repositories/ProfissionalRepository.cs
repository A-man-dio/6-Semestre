using DTO.Profissional;
using Mappers;
using Microsoft.EntityFrameworkCore;
using Model;
using Shared.Repository;

namespace DAL.Repositories;

public class ProfissionalRepository: IProfissionalRepository
{

    private readonly AppDbContext _context;
    
    public ProfissionalRepository(AppDbContext context)
    {
        _context = context;
    }
    
    
    public async Task<List<ProfissionalDto>> GetProfissionalsAsync()
    {
        return await _context.Profissionals.Select(profissional => profissional.ToProfissionalDto()).ToListAsync();
    }

    public async Task<ProfissionalDto?> GetProfissionalAsync(int id)
    {
        return await _context.Profissionals.Where(profissional => profissional.IdProfissional == id).Select(profissional => profissional.ToProfissionalDto()).FirstOrDefaultAsync();
    }

    public async Task<Profissional> CreateProfissionalAsync(Profissional profissionalModel)
    {
        await _context.Profissionals.AddAsync(profissionalModel);
        await _context.SaveChangesAsync();
        return profissionalModel;
    }

    public async Task<Profissional?> UpdateProfissionalAsync(int id, UpdateProfissionalRequestDto updateProfissionalRequestDto)
    {
        var existingProfissional = await _context.Profissionals.FirstOrDefaultAsync(profissional => profissional.IdProfissional == id);
        if (existingProfissional == null) return null;

        existingProfissional.Categoria = updateProfissionalRequestDto.Categoria;
        existingProfissional.Nome = updateProfissionalRequestDto.Nome;
        existingProfissional.Telemovel = updateProfissionalRequestDto.Telemovel;
        existingProfissional.Estado = updateProfissionalRequestDto.Estado;
        existingProfissional.Bi = updateProfissionalRequestDto.Bi;
        existingProfissional.Email = updateProfissionalRequestDto.Email;
        //existingProfissional.Foto = updateProfissionalRequestDto.Foto;
        existingProfissional.UpdatedOn = DateTime.Now;

        await _context.SaveChangesAsync();
        return existingProfissional;
    }

    public async Task<Profissional?> DeleteProfissionalAsync(int id)
    {
        var existingProfissional = await _context.Profissionals.FirstOrDefaultAsync(profissional => profissional.IdProfissional == id);
        if (existingProfissional == null) return null;
        _context.Profissionals.Remove(existingProfissional);
        await _context.SaveChangesAsync();
        return existingProfissional;
    }
}