using Model;
using System.Data.Entity;

namespace DAL
{
    public class AppDbContext : DbContext
    {

        public AppDbContext()
            : base("name=MyConnection")
        {

            this.Configuration.ProxyCreationEnabled = false;
            this.Configuration.AutoDetectChangesEnabled = false;
        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
        }

        public DbSet<Servico> Servicos { get; set; }
    }
}
