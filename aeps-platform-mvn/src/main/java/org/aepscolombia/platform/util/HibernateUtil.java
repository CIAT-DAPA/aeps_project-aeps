package org.aepscolombia.platform.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration config = null;
    config = new Configuration().configure("/hibernate.cfg.xml");
 
    config.setProperty("hibernate.connection.username", "ciat");
    config.setProperty("hibernate.connection.password", "GtA7U5BWcPATbGpT");
    String urlMysql = "jdbc:mysql://" + "localhost" + ":"
      + "3306" + "/"
      + "aeps_ciat_ext" + "?autoReconnect=true&&useSSL=false";
    config.setProperty("hibernate.connection.url", urlMysql);
    config.setProperty("hibernate.current_session_context_class", "thread");
    config.setProperty("hibernate.hikari.dataSource.url", urlMysql);
    config.setProperty("hibernate.hikari.dataSource.user", "ciat");
    config.setProperty("hibernate.hikari.dataSource.password", "GtA7U5BWcPATbGpT");
    config.setProperty("hibernate.hikari.connectionTimeout", "10000");
    // Minimum number of ideal connections in the pool
    config.setProperty("hibernate.hikari.minimumIdle", "1000");
    // Maximum number of actual connection in the pool
    config.setProperty("hibernate.hikari.maximumPoolSize", "5000");
    // Maximum time that a connection is allowed to sit ideal in the pool
    config.setProperty("hibernate.hikari.idleTimeout", "5000");
    config.setProperty("hibernate.bytecode.use_reflection_optimizer'", "false");
    // config.setProperty("hibernate.c3p0.min_size", "5");
    // System.out.println("url_mysql " + url_mysql);
    // System.out.println(url.toString());
 
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
    SessionFactory factory = config.buildSessionFactory(builder.build());
    return factory;
            // Create the SessionFactory from hibernate.cfg.xml
//            return new Configuration().configure().bu;
            //return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//            return new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            ex.printStackTrace();
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Database configuration
    public static String url = "jdbc:mysql://localhost:3306/ciat_ext";
    public static String dbdriver = "com.mysql.jdbc.Driver";
    public static String username = "ciat";
    public static String password = "GtA7U5BWcPATbGpT";
    static Connection conn;
    static Statement st;
    
    public static Connection getInstanceConnection() {
        if (!(conn instanceof Connection)) {
//            System.out.println("Conectando a la BD.");
            try {
                Class.forName(dbdriver);
                conn = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException ex) {
//                System.out.println(ex.getMessage());
            } catch (SQLException e) {
                // TODO Auto-generated catch block
//                System.out.println(e.getMessage());
            }
        }
//        System.out.println(conn);
        return conn;
    }
    
    public static void closeConnection() {
        try {
            if (conn instanceof Connection) {
                conn.close();
                conn = null;
//                System.out.println("Se ha cerrado la conexion de BD con exito.");
            }

        } catch (SQLException se) {
//            System.out.println(se.toString());
//            System.err.println("Se ha producido un error al cerrar la conexi�n de BD.");
//            System.err.println(se.getMessage());
        }
    }

    public static void setup(String sql) {
        try {
            createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
//            System.err.println("Got an exception! ");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void createStatement() {
        try {
            Class.forName(dbdriver);
            conn = DriverManager.getConnection(url, username, password);
            st = conn.createStatement();
        } catch (Exception e) {
//            System.err.println("Got an exception! ");
            e.printStackTrace();
            System.exit(0);
        }
    }

    // Drop table if exists
    public static void droptable(String sql) {
        try {
            createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
        }
    }

    public static void checkData(String sql) {
        String[] starray = sql.split(" ");
//        System.out.println("\n******** Table: " + starray[starray.length - 1] + " *******");
        try {
            createStatement();
            ResultSet r = st.executeQuery(sql);
            HibernateUtil.outputResultSet(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void outputResultSet(ResultSet rs) throws Exception {
        ResultSetMetaData metadata = rs.getMetaData();

        int numcols = metadata.getColumnCount();
        String[] labels = new String[numcols];
        int[] colwidths = new int[numcols];
        int[] colpos = new int[numcols];
        int linewidth;

        linewidth = 1;
        for (int i = 0; i < numcols; i++) {
            colpos[i] = linewidth;
            labels[i] = metadata.getColumnLabel(i + 1); // get its label
            int size = metadata.getColumnDisplaySize(i + 1);
            if (size > 30 || size == -1) {
                size = 30;
            }
            int labelsize = labels[i].length();
            if (labelsize > size) {
                size = labelsize;
            }
            colwidths[i] = size + 1; // save the column the size
            linewidth += colwidths[i] + 2; // increment total size
        }

        StringBuffer divider = new StringBuffer(linewidth);
        StringBuffer blankline = new StringBuffer(linewidth);
        for (int i = 0; i < linewidth; i++) {
            divider.insert(i, '-');
            blankline.insert(i, " ");
        }
        // Put special marks in the divider line at the column positions
        for (int i = 0; i < numcols; i++) {
            divider.setCharAt(colpos[i] - 1, '+');
        }
        divider.setCharAt(linewidth - 1, '+');

        // Begin the table output with a divider line
//        System.out.println(divider);

        // The next line of the table contains the column labels.
        // Begin with a blank line, and put the column names and column
        // divider characters "|" into it. overwrite() is defined below.
        StringBuffer line = new StringBuffer(blankline.toString());
        line.setCharAt(0, '|');
        for (int i = 0; i < numcols; i++) {
            int pos = colpos[i] + 1 + (colwidths[i] - labels[i].length()) / 2;
            overwrite(line, pos, labels[i]);
            overwrite(line, colpos[i] + colwidths[i], " |");
        }
//        System.out.println(line);
//        System.out.println(divider);

        while (rs.next()) {
            line = new StringBuffer(blankline.toString());
            line.setCharAt(0, '|');
            for (int i = 0; i < numcols; i++) {
                Object value = rs.getObject(i + 1);
                if (value != null) {
                    overwrite(line, colpos[i] + 1, value.toString().trim());
                    overwrite(line, colpos[i] + colwidths[i], " |");
                }
            }
//            System.out.println(line);
        }
//        System.out.println(divider);
    }

    static void overwrite(StringBuffer b, int pos, String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            b.setCharAt(pos + i, s.charAt(i));
        }
    }
}
