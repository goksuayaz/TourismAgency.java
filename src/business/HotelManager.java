package business;

import core.Helper;
import dao.HotelDao;
import entity.Hotel;

import java.util.ArrayList;

public class HotelManager {

    HotelDao hotelDao = new HotelDao();

    public Hotel getById(int id){
        return this.hotelDao.getById(id);

    }

    public ArrayList<Hotel> findAll(){
        return this.hotelDao.findAll();
    }

    public ArrayList<Object[]> getForTable(int size,ArrayList<Hotel> hotels){
        ArrayList<Object[]> hotelList = new ArrayList<>();
        for(Hotel obj : hotels){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getHotel_id();
            rowObject[i++] = obj.getHotel_name();
            rowObject[i++] = obj.getHotel_adress();
            rowObject[i++] = obj.getHotel_mail();
            rowObject[i++] = obj.getHotel_phone();
            rowObject[i++] = obj.getHotel_star();
            rowObject[i++] = obj.isHotel_carkpark();
            rowObject[i++] = obj.isHotel_wifi();
            rowObject[i++] = obj.isHotel_pool();
            rowObject[i++] = obj.isHotel_fitness();
            rowObject[i++] = obj.isHotel_concierge();
            rowObject[i++] = obj.isHotel_spa();
            rowObject[i++] = obj.isHotel_roomservice();
            hotelList.add(rowObject);
        }
        return hotelList;
    }

    public boolean save(Hotel hotel){
        if(hotel.getHotel_id() != 0){
            Helper.showMsg("error");
        }
        return this.hotelDao.save(hotel);
    }

    public boolean delete(int id){
        if(this.getById(id) == null){
            Helper.showMsg(id + " ID kayıtlı model bulunamadı");
            return false;
        }
        return this.hotelDao.delete(id);
    }

    public boolean update(Hotel hotel){
        if(this.getById(hotel.getHotel_id()) == null){
            Helper.showMsg(hotel.getHotel_id() + "ID kayıtlı model bulunamadı");
            return false;
        }
        return this.hotelDao.update(hotel);
    }
}