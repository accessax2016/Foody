using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FoodyServer.Controllers
{
    public class DanhMucController : ApiController
    {
        [HttpGet]
        public List<DanhMuc> GetDanhMuc()
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            return db.DanhMucs.ToList();
        }
    }
}
