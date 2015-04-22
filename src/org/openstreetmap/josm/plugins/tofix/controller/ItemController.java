package org.openstreetmap.josm.plugins.tofix.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.openstreetmap.josm.plugins.tofix.bean.ItemBean;
import org.openstreetmap.josm.plugins.tofix.bean.ItemKeeprightBean;
import org.openstreetmap.josm.plugins.tofix.util.Request;

/**
 *
 * @author ruben
 */
public class ItemController {

    private String url;

    Gson gson = new Gson();
 
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ItemBean getItemBean() {
        ItemBean itemBean = new ItemBean();
        String stringItem = null;
        try {
            stringItem = Request.sendPOST(getUrl());
            itemBean = gson.fromJson(stringItem, ItemBean.class);
            //itemBean.sumary();
            return itemBean;
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, "null");
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ItemKeeprightBean getItemKeeprightBean() {
        ItemKeeprightBean itemKeeprightBean = new ItemKeeprightBean();
        String stringItem = null;
        try {
            stringItem = Request.sendPOST(getUrl());
            itemKeeprightBean = gson.fromJson(stringItem, ItemKeeprightBean.class);
            return itemKeeprightBean;

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, "null");
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
