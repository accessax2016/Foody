using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FoodyServer.Controllers
{
    public class TaiKhoanController : ApiController
    {
        [HttpGet]
        public bool KiemTraDangNhap(string TaiKhoan, string MatKhau)
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from taikhoan in db.TaiKhoans
                 where (taikhoan.TaiKhoan1 == TaiKhoan && taikhoan.MatKhau == MatKhau)
                 select taikhoan
                 );
            if (result.Count() > 0)
                return true;
            return false;
        }
        [HttpGet]
        public List<TaiKhoan> GetTaiKhoan(string TaiKhoan)
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from taikhoan in db.TaiKhoans
                 where (taikhoan.TaiKhoan1 == TaiKhoan)
                 select taikhoan
                 );
            return result.ToList();
        }
        [HttpPost]
        public bool DangKyTaiKhoan(string TaiKhoan, string MatKhau, string TenHienThi)
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            TaiKhoan taikhoan = new TaiKhoan();
            taikhoan.TaiKhoan1 = TaiKhoan;
            taikhoan.MatKhau = MatKhau;
            taikhoan.TenHienThi = TenHienThi;
            db.TaiKhoans.InsertOnSubmit(taikhoan);
            try
            {
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
