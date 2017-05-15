using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FoodyServer.Controllers
{
    public class QuanHuyenController : ApiController
    {
        public class QuanHuyenCustom
        {
            public int id;
            public string TenQuyenHuyen;
        }
        [HttpGet]
        public List<QuanHuyenCustom> GetQuanHuyenTheoThanhPho(int MaThanhPho)
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from x in db.QuanHuyens
                 where x.MaTP == MaThanhPho
                 select new QuanHuyenCustom
                 {
                     id = x.id,
                     TenQuyenHuyen = x.TenQuanHuyen
                 });
            return result.ToList();
        }
    }
}
