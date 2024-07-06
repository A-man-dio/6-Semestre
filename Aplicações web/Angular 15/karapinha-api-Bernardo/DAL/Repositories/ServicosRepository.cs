using DTO.Servico;
using Mappers;
using Microsoft.EntityFrameworkCore;
using Model;
using Shared.Repository;

namespace DAL.Repositories;

public class ServicosRepository: IServicosRepository
{

    private readonly AppDbContext _context;
    
    public ServicosRepository(AppDbContext context)
    {
        _context = context;
    }
    
    public async Task<List<ServicoDto>> GetServicosAsync()
    {
        return await _context.Servicos.Select(servicos => servicos.ToServicoDto()).ToListAsync();
    }
    

    public async Task<ServicoDto?> GetServicoAsync(int id)
    {
        return await _context.Servicos.Where(servico => servico.IdServico == id).Select(servico => servico.ToServicoDto()).FirstOrDefaultAsync();
    }

    public async  Task<Servico> CreateServicoAsync(Servico servicoModel)
    {
        await _context.Servicos.AddAsync(servicoModel);
        await _context.SaveChangesAsync();
        return servicoModel;
    }

    public async Task<Servico?> UpdateServicoAsync(int id, UpdateServicoRequestDto servicoRequestDto)
    {
        var existingServico = await _context.Servicos.FirstOrDefaultAsync(servico => servico.IdServico == id);
        if (existingServico == null) return null;

        existingServico.Categoria = servicoRequestDto.Categoria;
        existingServico.Designacao = servicoRequestDto.Designacao;
        existingServico.Descricao = servicoRequestDto.Descricao;
        existingServico.Estado = servicoRequestDto.Estado;
        existingServico.Preco = servicoRequestDto.Preco;
        existingServico.UpdatedOn = DateTime.Now;

        await _context.SaveChangesAsync();
        return existingServico;
    }

    public async Task<Servico?> DeleteServicoAsync(int id)
    {
        var existingServico = await _context.Servicos.FirstOrDefaultAsync(servico => servico.IdServico == id);
        if (existingServico == null) return null;
        _context.Servicos.Remove(existingServico);
        await _context.SaveChangesAsync();
        return existingServico;
    }
}