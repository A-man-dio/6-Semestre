using Model;
using Microsoft.EntityFrameworkCore;

namespace DAL;

public class AppDbContext: DbContext
{
    
    public AppDbContext(DbContextOptions dbContextOptions)
        : base(dbContextOptions)
    {
    }

    public DbSet<Servico> Servicos { get; set; }
    public DbSet<Profissional> Profissionals { get; set; }
    public DbSet<ProfissionalHorario> ProfissionalHorarios { get; set; }
    public DbSet<Cliente> Clientes { get; set; }
    
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlServer("Server=PRINTF\\ROOT;Database=KarapinhaDB;User Id=sa;Password=1234567890;TrustServerCertificate=True");
    }
}