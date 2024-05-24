using DTO;
using Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ApiCodeFirst.Api
{
    [RoutePrefix("api/servicos")]
    public class ServicosController : ApiController
    {

        private ServicoService servicoService;

        public ServicosController()
        {
            servicoService = new ServicoService();

        }

        // GET: api/Servicos
        [HttpGet, Route("GetServicos")]
        public IEnumerable<ServicoDto> GetServicos()
        {
            return this.servicoService.GetServicos();
        }

        // GET: api/Servicos/5
        [HttpGet, Route("GetServico")]
        public ServicoDto GetServico(int servicoId)
        {
            return this.servicoService.GetServico(servicoId);
        }

     
    }
}
