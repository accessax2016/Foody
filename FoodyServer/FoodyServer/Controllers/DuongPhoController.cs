using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FoodyServer.Controllers
{
    public class DuongPhoController : ApiController
    {
        public class DuongPhoCustom
        {
            public int MaDuong;
            public string TenDuong;
        }
        [HttpGet]
        public List<DuongPhoCustom> GetDuongPhoTheoQuanHuyen(int MaQuanHuyen)
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from x in db.DuongPhos
                 where x.MaQuan == MaQuanHuyen
                 select new DuongPhoCustom
                 {
                     MaDuong = x.MaDuong,
                     TenDuong = x.TenDuong
                 });
            return result.ToList();
        }
    }
}
