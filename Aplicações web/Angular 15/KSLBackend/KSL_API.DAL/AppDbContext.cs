using KSL_API.Models;
using Microsoft.EntityFrameworkCore;

namespace KSL_API.DAL;

public class AppDbContext : DbContext
{
    public AppDbContext()
    {
        
    }
    public AppDbContext(DbContextOptions dbContextOptions) 
        : base(dbContextOptions)
    {
        
    }
    
    public DbSet<Categoria> Categoria { get; set; }
    
    public DbSet<Horario> Horario { get; set; }
    
    public DbSet<ItenMarcacao> ItenMarcacao { get; set; }
    public DbSet<Marcacao> Marcacao { get; set; }
    public DbSet<Profissional> Profissional { get; set; }
    public DbSet<Servico> Servico { get; set; }
    public DbSet<Utilizador> Utilizador { get; set; }
    
    
    //outras tabelas
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlServer("Server=localhost,1433;Initial Catalog=KSLDB;User=sa;Password=#Preciosa1;TrustServerCertificate=True");
    }
    
}