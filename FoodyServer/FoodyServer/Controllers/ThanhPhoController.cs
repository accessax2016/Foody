using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FoodyServer.Controllers
{
    public class ThanhPhoController : ApiController
    {
        public class ThanhPhoCustom
        {
            public int id;
            public string TenThanhPho;
        }
        [HttpGet]
        public List<ThanhPhoCustom> GetThanhPho()
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                from x in db.ThanhPhos
                select new ThanhPhoCustom
                {
                    id = x.id,
                    TenThanhPho = x.TenThanhPho
                });
            return result.ToList();
        }
    }
}
