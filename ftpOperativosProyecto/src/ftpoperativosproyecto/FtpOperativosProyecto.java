/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftpoperativosproyecto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.listener.ListenerFactory;

/**
 *
 * @author Horacio
 */
import java.util.Scanner;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.Ftplet;
import org.apache.ftpserver.ftplet.FtpletContext;
import org.apache.ftpserver.ftplet.FtpletResult;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.ssl.SslConfigurationFactory;
import org.apache.ftpserver.usermanager.PasswordEncryptor;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.SaltedPasswordEncryptor;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

public class FtpOperativosProyecto {

    /**
     * @param args the command line arguments
     * @throws org.apache.ftpserver.ftplet.FtpException
     */
    public static void main(String[] args) throws FtpException {
        System.out.println("Sistemas Operativos I - Proyecto \nIntegrantes:\nHoracio Galdamez\nJorge Caballero\nJose Pejuan\nJose Lopez");
        ArrayList<User> new_users = new ArrayList();
        int opcion = 1;
        Scanner sc = new Scanner(System.in);
        while (opcion != 3) {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1.- Crear Usuarios");
            System.out.println("2.- Iniciar Servidor FTP");
            System.out.println("3.- Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese nombre de usuario");
                    String name = sc.next();
                    System.out.println("Ingrese contraseña");
                    String pass = sc.next();
                    Boolean success = (new File("/ftp/data/" + name)).mkdirs();
                    if (success) {
                        new_users.add(new User(name, pass));
                        System.out.println("El usuario se creo con exito!");
                    }
                    break;
                case 2:
                    FtpServerFactory serverFactory = new FtpServerFactory();
                    ListenerFactory factory = new ListenerFactory();
                    factory.setPort(2220);// set the port of the listener (choose your desired port, not 1234)
                    serverFactory.addListener("default", factory.createListener());
                    PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
                    userManagerFactory.setFile(new File("/ftp/data/config.xml"));//choose any. We're telling the FTP-server where to read it's user list
                    userManagerFactory.setPasswordEncryptor(new PasswordEncryptor() {//We store clear-text passwords in this example

                        @Override
                        public String encrypt(String password) {
                            return password;
                        }

                        @Override
                        public boolean matches(String passwordToCheck, String storedPassword) {
                            return passwordToCheck.equals(storedPassword);
                        }
                    });
                    //Let's add a user, since our myusers.properties files is empty on our first test run
                    for (int i = 0; i < new_users.size(); i++) {
                        User current = new_users.get(i);
                        BaseUser user = new BaseUser();
                        user.setName(current.getUsername());
                        user.setPassword(current.getPassword());
                        user.setHomeDirectory("/ftp/data/" + current.getUsername());
                        List<Authority> authorities = new ArrayList<Authority>();
                        authorities.add(new WritePermission());
                        user.setAuthorities(authorities);
                        UserManager um = userManagerFactory.createUserManager();
                        try {
                            um.save(user);//Save the user to the user list on the filesystem
                        } catch (FtpException e1) {
                            //Deal with exception as you need
                        }
                        serverFactory.setUserManager(um);
                    }

                    Map<String, Ftplet> m = new HashMap<String, Ftplet>();
                    m.put("miaFtplet", new Ftplet() {

                        @Override
                        public void init(FtpletContext ftpletContext) throws FtpException {
                //System.out.println("init");
                            //System.out.println("Thread #" + Thread.currentThread().getId());
                        }

                        @Override
                        public void destroy() {
                //System.out.println("destroy");
                            //System.out.println("Thread #" + Thread.currentThread().getId());
                        }

                        @Override
                        public FtpletResult beforeCommand(FtpSession session, FtpRequest request) throws FtpException, IOException {
            //System.out.println("beforeCommand " + session.getUserArgument() + " : " + session.toString() + " | " + request.getArgument() + " : " + request.getCommand() + " : " + request.getRequestLine());
                            //System.out.println("Thread #" + Thread.currentThread().getId());

                            //do something
                            return FtpletResult.DEFAULT;//...or return accordingly
                        }

                        @Override
                        public FtpletResult afterCommand(FtpSession session, FtpRequest request, FtpReply reply) throws FtpException, IOException {
            //System.out.println("afterCommand " + session.getUserArgument() + " : " + session.toString() + " | " + request.getArgument() + " : " + request.getCommand() + " : " + request.getRequestLine() + " | " + reply.getMessage() + " : " + reply.toString());
                            //System.out.println("Thread #" + Thread.currentThread().getId());

                            //do something
                            return FtpletResult.DEFAULT;//...or return accordingly
                        }

                        @Override
                        public FtpletResult onConnect(FtpSession session) throws FtpException, IOException {
            //System.out.println("onConnect " + session.getUserArgument() + " : " + session.toString());
                            //System.out.println("Thread #" + Thread.currentThread().getId());

                            //do something
                            return FtpletResult.DEFAULT;//...or return accordingly
                        }

                        @Override
                        public FtpletResult onDisconnect(FtpSession session) throws FtpException, IOException {
            //System.out.println("onDisconnect " + session.getUserArgument() + " : " + session.toString());
                            //System.out.println("Thread #" + Thread.currentThread().getId());

                            //do something
                            return FtpletResult.DEFAULT;//...or return accordingly
                        }

                    });
                    serverFactory.setFtplets(m);
        //Map<String, Ftplet> mappa = serverFactory.getFtplets();
                    //System.out.println(mappa.size());
                    //System.out.println("Thread #" + Thread.currentThread().getId());
                    //System.out.println(mappa.toString());
                    FtpServer server = serverFactory.createServer();

                    try {
                        server.start();//Your FTP server starts listening for incoming FTP-connections, using the configuration options previously set
                    } catch (FtpException ex) {
                        //Deal with exception as you need
                    }
                    break;
            }

        }
    }

}
