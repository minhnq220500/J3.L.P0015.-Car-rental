/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.dtos;

import java.util.HashMap;
import minhnq.daos.CarDAO;

/**
 *
 * @author Ticket 1
 */
public class CartDTO {
    private String email;
    private HashMap<String, CarDTO> cart;

    public CartDTO() {
    }

    public CartDTO(String email) {
        this.email = email;
        this.cart = cart;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cart
     */
    public HashMap<String, CarDTO> getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(HashMap<String, CarDTO> cart) {
        this.cart = cart;
    }

    public void addToCart(CarDTO dto) throws Exception {
//        if (this.getCart().containsKey(dto.getProductID())) {
//            int newQuantity = this.getCart().get(dto.getProductID()).getQuantity() + 1;
//            this.getCart().get(dto.getProductID()).setQuantity(newQuantity);
//        } else {
//            this.getCart().put(dto.getProductID(), dto);
//        }

        if (getCart() == null) {
            setCart(new HashMap<>());//tạo ra cái giỏ hàng
            
            getCart().put(dto.getCarID(), dto);
        } 
        
        else if (getCart() != null) {
            if (getCart().containsKey(dto.getCarID())) {

                //khi nó max rồi thì nó sẽ không add thêm
//                int quantity = this.getCart().get(dto.getCarID()).getQuantity();
//                int availableQuantity = this.getCart().get(dto.getCarID()).getAvailableQuantity();
                
//                if (quantity == availableQuantity) {
//                    dto.setQuantity(quantity);
//                } else {
//                    dto.setQuantity(quantity + 1);
//                    getCart().put(dto.getCarID(), dto);
//                }
                getCart().put(dto.getCarID(), dto);

            } //if ID sản phẩm k có trong giỏ hàng
            else if (getCart().containsKey(dto.getCarID()) == false) {
                getCart().put(dto.getCarID(), dto);
            }
        }

    }

    public void update(CarDTO carDTO) {
        if (this.getCart() != null) {
            if (this.getCart().containsKey(carDTO.getCarID())) {
                getCart().replace(carDTO.getCarID(), carDTO);
            }
        }
    }

    public void remove(String id) throws Exception {
        if (this.getCart().containsKey(id)) {
            this.getCart().remove(id);
        }
    }

    public float getTotalPrice() throws Exception {
        float result = 0;
        for (CarDTO dto : this.getCart().values()) {
            result += dto.getQuantity() * dto.getPrice();
        }
        return result;
    }
    
    
}
