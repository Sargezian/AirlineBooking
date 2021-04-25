package server.model.database;

public class ShoppingCartImpl implements ShoppingCartDao {

    private static ShoppingCartImpl daoInstance;

    public static synchronized ShoppingCartImpl getInstance(){

        if (daoInstance == null){
            daoInstance = new ShoppingCartImpl();
        }
        return daoInstance;
    }




}
