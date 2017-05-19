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
        public TaiKhoan DangNhapTaiKhoan(string TaiKhoan, string MatKhau)
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            return db.TaiKhoans.FirstOrDefault(tk => (tk.TaiKhoan1 == TaiKhoan && tk.MatKhau == MatKhau));          
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
        [HttpGet]
        public bool DangKyTaiKhoan(string TaiKhoan, string MatKhau, string TenHienThi)
        {
            try
            {
                DBFoodyDataContext db = new DBFoodyDataContext();
                TaiKhoan taikhoan = new TaiKhoan();
                taikhoan.TaiKhoan1 = TaiKhoan;
                taikhoan.MatKhau = MatKhau;
                taikhoan.TenHienThi = TenHienThi;
                db.TaiKhoans.InsertOnSubmit(taikhoan);
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
