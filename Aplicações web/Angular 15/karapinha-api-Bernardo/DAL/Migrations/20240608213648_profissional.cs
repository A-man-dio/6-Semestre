using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace DAL.Migrations
{
    /// <inheritdoc />
    public partial class profissional : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Profissional",
                columns: table => new
                {
                    IdProfissional = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Categoria = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Nome = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Email = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Telemovel = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Bi = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Foto = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    Estado = table.Column<int>(type: "int", nullable: false),
                    CreatedOn = table.Column<DateTime>(type: "datetime2", nullable: false),
                    UpdatedOn = table.Column<DateTime>(type: "datetime2", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Profissional", x => x.IdProfissional);
                });

            migrationBuilder.CreateTable(
                name: "ProfissionalHorario",
                columns: table => new
                {
                    IdProfissionalHorario = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    IdProfissional = table.Column<int>(type: "int", nullable: false),
                    ProfissionalIdProfissional = table.Column<int>(type: "int", nullable: true),
                    Horario = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_ProfissionalHorario", x => x.IdProfissionalHorario);
                    table.ForeignKey(
                        name: "FK_ProfissionalHorario_Profissional_ProfissionalIdProfissional",
                        column: x => x.ProfissionalIdProfissional,
                        principalTable: "Profissional",
                        principalColumn: "IdProfissional");
                });

            migrationBuilder.CreateIndex(
                name: "IX_ProfissionalHorario_ProfissionalIdProfissional",
                table: "ProfissionalHorario",
                column: "ProfissionalIdProfissional");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "ProfissionalHorario");

            migrationBuilder.DropTable(
                name: "Profissional");
        }
    }
}
