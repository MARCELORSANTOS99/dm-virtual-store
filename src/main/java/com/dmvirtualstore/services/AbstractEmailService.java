package com.dmvirtualstore.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.dmvirtualstore.domain.Cliente;
import com.dmvirtualstore.domain.Pedido;



public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;
	
	/*
	@Autowired
	TemplateEngine templateEngine;
	*/
	
	/*
	@Autowired
	private JavaMailSender javaMailSender;
	*/
	
	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
		
	}
	
	@Override
	public void sendNewPasswordEmail(Cliente cliente, String newPass) {
		
		SimpleMailMessage sm = preparePasswordEmail(cliente,newPass);
		sendEmail(sm);
		
	}

	protected SimpleMailMessage preparePasswordEmail(Cliente cliente, String newPass) {
		
		SimpleMailMessage sm = new SimpleMailMessage();
		
		sm.setTo(cliente.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitalção de nova senha ");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha " + newPass);
		return sm;

	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {

		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! Códiogo " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		
		return sm;
	}
	
	/*
	protected String htmlFromTemplatePedido(Pedido obj) {
		Context context = new Context();
		context.setVariable("pedido", obj);
		return templateEngine.process("email/confirmacaoPedido", context);
		
	}
	*/
	
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
		
	/*
		try {
			//MimeMessage mm = prepareMimeMessageFromPedido(obj);
			sendHtmlEmail(mm);	
		} catch (MessagingException e) {
			sendOrderConfirmationEmail(obj);

		}
		
		*/
	}
	/*
	protected MimeMessage prepareMimeMessageFromPedido(Pedido obj) throws MessagingException {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		
		mmh.setTo(obj.getCliente().getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Pedido confirmado! Código " + obj.getId());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplatePedido(obj), true);

		return mimeMessage;
	}
	*/
	


	

}