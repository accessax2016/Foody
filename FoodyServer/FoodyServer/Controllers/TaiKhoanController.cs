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
        public class TaiKhoanCustom
        {
            public String TaiKhoan;
            public String MatKhau;
            public String TenHienThi;
            public String HinhDaiDien;
        }
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
        [HttpGet]
        public bool DoiMatKhau(string TaiKhoan, string MatKhau, string MatKhauMoi)
        {
            try
            {
                DBFoodyDataContext db = new DBFoodyDataContext();
                TaiKhoan taikhoan = db.TaiKhoans.FirstOrDefault(x => x.TaiKhoan1 == TaiKhoan & x.MatKhau == MatKhau);
                if (taikhoan == null)
                    return false;
                taikhoan.MatKhau = MatKhauMoi;
                db.SubmitChanges();
                return true;
            }
            catch (Exception e)
            {
                return false;
            }
        }
        
        [HttpPost]
        public bool DoiHinhDaiDien(TaiKhoanCustom tk)
        {
            try
            {
                DBFoodyDataContext db = new DBFoodyDataContext();
                TaiKhoan taikhoan = db.TaiKhoans.FirstOrDefault(x => x.TaiKhoan1 == tk.TaiKhoan);
                if (taikhoan == null)
                    return false;

                taikhoan.HinhDaiDien = Convert.FromBase64String(tk.HinhDaiDien);
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
