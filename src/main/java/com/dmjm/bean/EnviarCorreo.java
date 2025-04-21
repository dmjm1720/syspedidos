package com.dmjm.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.context.FacesContext;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.dmjm.model.Usuarios;

public class EnviarCorreo {

    public void enviarCorreo(String pedido, String vendedor, String cliente) throws MessagingException {
        Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fecha = dateFormat.format(cal.getTime());
        Properties props = new Properties();
        props.put("mail.smtp.host", "p3plcpnl1014.prod.phx3.secureserver.net");
        props.setProperty("mail.smtp.starttls.enable", "true"); //Habilitar a true si se usa WildFly
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "sistemas@bacrocorp.com");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(false);

        BodyPart texto = new MimeBodyPart();
        texto.setContent("<html><head><title></title></head>"
                + "<body>"
                + "<table width='678' height='315' border='0' bordercolor='#0000FF' bgcolor='#FFFFFF'>"
                + "<tr>"
                + "<td height='50' colspan='3' bordercolor='#FFFFFF'><br><br></td>"
                + "</tr>"
                + "<tr>"
                + "<td colspan='3' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><font color='#086A87'>Se ha registrado un nuevo pedido: </font><br><br>"
                + "<font color='#17202a'>Pedido no: </font><i><font color='#086A87'> " + pedido + "</font></i> <br>"
                + "<font color='#17202a'>Vendedor: </font><i><font color='#086A87'> " + vendedor + "</font></i> <br>"
                + "<font color='#17202a'>Cliente:</font> <font color='#086A87'><i> " + cliente + " </i></font><br>"
                + "<font color='#17202a'></font> <font color='#086A87'><i>  </i></font><br><font color='black'><b>Fecha del pedido: " + fecha.toUpperCase() + "</b></font><br></td>"
                + "</tr>"
                + "<tr>"
                + "<td width='425' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><br><font color='#17202a'>Sistema de Pedidos | </font><font color='#E60013'>Insoftec</font><br>"
                + "<a href='http://insoftec.com' target='_blank'><img src='cid:image' width='45%'/></a></td>"
                + "<td width='122' bordercolor='#FFFFFF'></td>"
                + "<td width='222' rowspan='2' bordercolor='#FFFFFF'></td>"
                + "</tr>"
                + "<tr>"
                + "<td colspan='2' bordercolor='#17202a'><br><br><p align='center' style='font-family:calibri; font-size:15px'><font color='#086A87'><br> Mensaje enviado desde el Sistema de Pedidos.</font></p></td>"
                + "</tr>"
                + "</table>"
                + "</body></html>", "text/html");

///        BodyPart adjunto = new MimeBodyPart();
//        adjunto.setDataHandler(new DataHandler(new FileDataSource("C:\\PROVEEDORES\\JasperReports - poliza.pdf")));
//        adjunto.setFileName("Test.pdf");
        MimeMultipart multiParte = new MimeMultipart();
        BodyPart imagen = new MimeBodyPart();
        DataSource fds = new FileDataSource("C:\\img\\logo.png");
        imagen.setDataHandler(new DataHandler(fds));
        imagen.setHeader("Content-ID", "<image>");

        multiParte.addBodyPart(texto);
        // multiParte.addBodyPart(adjunto);
        multiParte.addBodyPart(imagen);

        MimeMessage message = new MimeMessage(session);

// Se rellena el From
        message.setFrom(new InternetAddress("sistemas@bacrocorp.com"));

// Se rellenan los destinatarios
        message.addRecipients(Message.RecipientType.TO, us.getCorreo());

        message.addRecipient(Message.RecipientType.BCC, new InternetAddress("mario.arias@bacrocorp.com"));

// Se rellena el subject
        message.setSubject("Sistema de pedidos");

// Se mete el texto y la foto adjunta.
        message.setContent(multiParte);

        Transport t = session.getTransport("smtp");
        t.connect("sistemas@bacrocorp.com", "}2bmrCg#H=9.");
        t.sendMessage(message, message.getAllRecipients());
        t.close();
    }
}
