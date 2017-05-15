using System;
using System.Collections.Generic;
using System.Data.Linq;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FoodyServer.Controllers
{
    public class ODauController : ApiController
    {
        public class QuanAnCustom
        {
            public int id;
            public string TenQuan;
            public string DiaChi;
            public Binary HinhAnh;
            public double? Diem;
            public string TenDuong;
            public string TenQuanHuyen;
            public string TenThanhPho;
        }
        [HttpGet]
        public List<QuanAnCustom> GetODau()
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from quanan in db.QuanAns
                 join duongpho in db.DuongPhos on quanan.MaDuong equals duongpho.MaDuong
                 join quanhuyen in db.QuanHuyens on duongpho.MaQuan equals quanhuyen.id
                 join thanhpho in db.ThanhPhos on quanhuyen.MaTP equals thanhpho.id
                 select new QuanAnCustom
                 {
                     id = quanan.id,
                     TenQuan = quanan.TenQuan,
                     DiaChi = quanan.DiaChi,
                     HinhAnh = quanan.HinhAnh,
                     Diem = quanan.Diem,
                     TenDuong = duongpho.TenDuong,
                     TenQuanHuyen = quanhuyen.TenQuanHuyen,
                     TenThanhPho = thanhpho.TenThanhPho
                 });
            return result.ToList();
        }
        [HttpGet]
        public List<QuanAnCustom> GetODauTheoDanhMuc(string TenDanhMuc)
        {
            if (TenDanhMuc == "Danh mục")
                return GetODau();
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from quanan in db.QuanAns
                 join duongpho in db.DuongPhos on quanan.MaDuong equals duongpho.MaDuong
                 join quanhuyen in db.QuanHuyens on duongpho.MaQuan equals quanhuyen.id
                 join thanhpho in db.ThanhPhos on quanhuyen.MaTP equals thanhpho.id
                 join danhmuc in db.DanhMucs on quanan.MaDanhMuc equals danhmuc.MaDanhMuc
                 where danhmuc.TenDanhMuc == TenDanhMuc
                 select new QuanAnCustom
                 {
                     id = quanan.id,
                     TenQuan = quanan.TenQuan,
                     DiaChi = quanan.DiaChi,
                     HinhAnh = quanan.HinhAnh,
                     Diem = quanan.Diem,
                     TenDuong = duongpho.TenDuong,
                     TenQuanHuyen = quanhuyen.TenQuanHuyen,
                     TenThanhPho = thanhpho.TenThanhPho
                 });
            return result.ToList();
        }
        [HttpGet]
        public List<QuanAnCustom> GetODauTheoDuongPho(string TenDuong)
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from quanan in db.QuanAns
                 join duongpho in db.DuongPhos on quanan.MaDuong equals duongpho.MaDuong
                 join quanhuyen in db.QuanHuyens on duongpho.MaQuan equals quanhuyen.id
                 join thanhpho in db.ThanhPhos on quanhuyen.MaTP equals thanhpho.id
                 join danhmuc in db.DanhMucs on quanan.MaDanhMuc equals danhmuc.MaDanhMuc
                 where duongpho.TenDuong == TenDuong
                 select new QuanAnCustom
                 {
                     id = quanan.id,
                     TenQuan = quanan.TenQuan,
                     DiaChi = quanan.DiaChi,
                     HinhAnh = quanan.HinhAnh,
                     Diem = quanan.Diem,
                     TenDuong = duongpho.TenDuong,
                     TenQuanHuyen = quanhuyen.TenQuanHuyen,
                     TenThanhPho = thanhpho.TenThanhPho
                 });
            return result.ToList();
        }
        [HttpGet]
        public List<QuanAnCustom> GetODauTheoQuanHuyen(string TenQuanHuyen)
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from quanan in db.QuanAns
                 join duongpho in db.DuongPhos on quanan.MaDuong equals duongpho.MaDuong
                 join quanhuyen in db.QuanHuyens on duongpho.MaQuan equals quanhuyen.id
                 join thanhpho in db.ThanhPhos on quanhuyen.MaTP equals thanhpho.id
                 join danhmuc in db.DanhMucs on quanan.MaDanhMuc equals danhmuc.MaDanhMuc
                 where quanhuyen.TenQuanHuyen == TenQuanHuyen
                 select new QuanAnCustom
                 {
                     id = quanan.id,
                     TenQuan = quanan.TenQuan,
                     DiaChi = quanan.DiaChi,
                     HinhAnh = quanan.HinhAnh,
                     Diem = quanan.Diem,
                     TenDuong = duongpho.TenDuong,
                     TenQuanHuyen = quanhuyen.TenQuanHuyen,
                     TenThanhPho = thanhpho.TenThanhPho
                 });
            return result.ToList();
        }
        [HttpGet]
        public List<QuanAnCustom> GetODauTheoThanhPho(string TenThanhPho)
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from quanan in db.QuanAns
                 join duongpho in db.DuongPhos on quanan.MaDuong equals duongpho.MaDuong
                 join quanhuyen in db.QuanHuyens on duongpho.MaQuan equals quanhuyen.id
                 join thanhpho in db.ThanhPhos on quanhuyen.MaTP equals thanhpho.id
                 join danhmuc in db.DanhMucs on quanan.MaDanhMuc equals danhmuc.MaDanhMuc
                 where thanhpho.TenThanhPho == TenThanhPho
                 select new QuanAnCustom
                 {
                     id = quanan.id,
                     TenQuan = quanan.TenQuan,
                     DiaChi = quanan.DiaChi,
                     HinhAnh = quanan.HinhAnh,
                     Diem = quanan.Diem,
                     TenDuong = duongpho.TenDuong,
                     TenQuanHuyen = quanhuyen.TenQuanHuyen,
                     TenThanhPho = thanhpho.TenThanhPho
                 });
            return result.ToList();
        }
        [HttpGet]
        public List<QuanAnCustom> GetODauList(string TenDanhMuc, string KieuDiaDiem, string TenDiaDiem)
        {
            List<QuanAnCustom> quanantheodanhmuc = new List<QuanAnCustom>();
            if (TenDanhMuc == "Danh mục")
                quanantheodanhmuc = GetODau();
            else
                quanantheodanhmuc = GetODauTheoDanhMuc(TenDanhMuc);

            List<QuanAnCustom> quanantheodiadiem = new List<QuanAnCustom>();
            switch (KieuDiaDiem)
            {
                case "ThanhPho":
                    quanantheodiadiem = GetODauTheoThanhPho(TenDiaDiem);
                    break;
                case "QuanHuyen":
                    quanantheodiadiem = GetODauTheoQuanHuyen(TenDiaDiem);
                    break;
                case "DuongPho":
                    quanantheodiadiem = GetODauTheoDuongPho(TenDiaDiem);
                    break;
            }

            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from x in quanantheodanhmuc
                 join y in quanantheodiadiem on x.id equals y.id
                 select new QuanAnCustom
                 {
                     id = x.id,
                     TenQuan = x.TenQuan,
                     DiaChi = x.DiaChi,
                     HinhAnh = x.HinhAnh,
                     Diem = x.Diem,
                     TenDuong = x.TenDuong,
                     TenQuanHuyen = x.TenQuanHuyen,
                     TenThanhPho = x.TenThanhPho
                 });
            return result.ToList();



        }
    }
}
