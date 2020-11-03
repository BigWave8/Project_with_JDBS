package com.lyndexter;

import com.lyndexter.persistent.ConnectionManager;
import com.lyndexter.view.View;
import java.io.IOException;
import java.sql.SQLException;

public class App {
  public static void main(final String[] args) throws IOException, SQLException {
    new View().show();
    ConnectionManager.closeConnection();
  }
}
