using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FoodyServer.Controllers
{
    public class QuanAnController : ApiController
    {
        public class QuanAnCustom
        {
            //public int id;
            public string TenQuan;
            public string DiaChi;
            public string HinhAnh;
            public string SDT;
            public int MaDuong;
            public int MaDanhMuc;
            public double? Diem;
            public double? Lat;
            public double? Long;
            public string GioBatDau;
            public string GioKetThuc;
            public double? GiaThapNhat;
            public double? GiaCaoNhat;
            public string MoTa;
            public string ThoiGianThem;
        }

        [HttpPost]
        public bool ThemQuanAn(QuanAnCustom qa)
        {
            try
            {
                DBFoodyDataContext db = new DBFoodyDataContext();
                QuanAn quanan = new QuanAn();
                //quanan.id = qa.id;
                quanan.TenQuan = qa.TenQuan;
                quanan.DiaChi = qa.DiaChi;
                quanan.HinhAnh = Convert.FromBase64String(qa.HinhAnh);
                quanan.SDT = qa.SDT;
                quanan.MaDuong = qa.MaDuong;
                quanan.MaDanhMuc = qa.MaDanhMuc;
                quanan.Diem = qa.Diem;
                quanan.Lat = Convert.ToSingle(qa.Lat);
                quanan.Long = Convert.ToSingle(qa.Long);
                quanan.GioBatDau = TimeSpan.Parse(qa.GioBatDau);
                quanan.GioKetThuc = TimeSpan.Parse(qa.GioKetThuc);
                quanan.GiaThapNhat = Convert.ToDecimal(qa.GiaThapNhat);
                quanan.GiaCaoNhat = Convert.ToDecimal(qa.GiaCaoNhat);
                quanan.MoTa = qa.MoTa;
                quanan.ThoiGianThem = DateTime.Parse(qa.ThoiGianThem);
                db.QuanAns.InsertOnSubmit(quanan);
                db.SubmitChanges();
                return true;
            }
            catch (Exception e)
            {
                return false;
            }
        }
    }
}
