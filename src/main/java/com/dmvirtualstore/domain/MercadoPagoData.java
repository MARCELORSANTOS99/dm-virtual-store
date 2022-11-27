package com.dmvirtualstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class MercadoPagoData implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private int id;
    private Date date_created;
    private String date_approved;
    private Date date_last_updated;
    private Date date_of_expiration;
    private Object money_release_date;
    private Object money_release_status;
    private String operation_type;
    private Object issuer_id;
    private String payment_method_id;
    private String payment_type_id;
    private String status;
    private String status_detail;
    private String currency_id;
    private String description;
    private boolean live_mode;
    private Object sponsor_id;
    private Object authorization_code;
    private String money_release_schema;
    private int taxes_amount;
    private Object counter_currency;
    private Object brand_id;
    private int shipping_amount;
    private String build_version;
    private Object pos_id;
    private Object store_id;
    private Object integrator_id;
    private Object platform_id;
    private String corporation_id;
    private int collector_id;
    private Payer payer;
    private Object marketplace_owner;
    private Metadata metadata;
    private AdditionalInfo additional_info;
    private Order order;
    private Object external_reference;
    private double transaction_amount;
    private int transaction_amount_refunded;
    private int coupon_amount;
    private Object differential_pricing_id;
    private Object deduction_schema;
    private Object callback_url;
    private int installments;
    private TransactionDetails transaction_details;
    private ArrayList<Object> fee_details;
    private ArrayList<Object> charges_details;
    private boolean captured;
    private boolean binary_mode;
    private Object call_for_authorize_id;
    private Object statement_descriptor;
    private Card card;
    private String notification_url;
    private ArrayList<Object> refunds;
    private String processing_mode;
    private Object merchant_account_id;
    private Object merchant_number;
    private ArrayList<Object> acquirer_reconciliation;
    private PointOfInteraction point_of_interaction;
    
    
    
	public MercadoPagoData() {
	}
	
	public MercadoPagoData(String description, Payer payer, double transaction_amount, String notification_url) {
		super();
		this.description = description;
		this.payer = payer;
		this.transaction_amount = transaction_amount;
		this.notification_url = notification_url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public Object getDate_approved() {
		return date_approved;
	}
	public void setDate_approved(String date_approved) {
		this.date_approved = date_approved;
	}
	public Date getDate_last_updated() {
		return date_last_updated;
	}
	public void setDate_last_updated(Date date_last_updated) {
		this.date_last_updated = date_last_updated;
	}
	public Date getDate_of_expiration() {
		return date_of_expiration;
	}
	public void setDate_of_expiration(Date date_of_expiration) {
		this.date_of_expiration = date_of_expiration;
	}
	public Object getMoney_release_date() {
		return money_release_date;
	}
	public void setMoney_release_date(Object money_release_date) {
		this.money_release_date = money_release_date;
	}
	public Object getMoney_release_status() {
		return money_release_status;
	}
	public void setMoney_release_status(Object money_release_status) {
		this.money_release_status = money_release_status;
	}
	public String getOperation_type() {
		return operation_type;
	}
	public void setOperation_type(String operation_type) {
		this.operation_type = operation_type;
	}
	public Object getIssuer_id() {
		return issuer_id;
	}
	public void setIssuer_id(Object issuer_id) {
		this.issuer_id = issuer_id;
	}
	public String getPayment_method_id() {
		return payment_method_id;
	}
	public void setPayment_method_id(String payment_method_id) {
		this.payment_method_id = payment_method_id;
	}
	public String getPayment_type_id() {
		return payment_type_id;
	}
	public void setPayment_type_id(String payment_type_id) {
		this.payment_type_id = payment_type_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus_detail() {
		return status_detail;
	}
	public void setStatus_detail(String status_detail) {
		this.status_detail = status_detail;
	}
	public String getCurrency_id() {
		return currency_id;
	}
	public void setCurrency_id(String currency_id) {
		this.currency_id = currency_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isLive_mode() {
		return live_mode;
	}
	public void setLive_mode(boolean live_mode) {
		this.live_mode = live_mode;
	}
	public Object getSponsor_id() {
		return sponsor_id;
	}
	public void setSponsor_id(Object sponsor_id) {
		this.sponsor_id = sponsor_id;
	}
	public Object getAuthorization_code() {
		return authorization_code;
	}
	public void setAuthorization_code(Object authorization_code) {
		this.authorization_code = authorization_code;
	}
	public String getMoney_release_schema() {
		return money_release_schema;
	}
	public void setMoney_release_schema(String money_release_schema) {
		this.money_release_schema = money_release_schema;
	}
	public int getTaxes_amount() {
		return taxes_amount;
	}
	public void setTaxes_amount(int taxes_amount) {
		this.taxes_amount = taxes_amount;
	}
	public Object getCounter_currency() {
		return counter_currency;
	}
	public void setCounter_currency(Object counter_currency) {
		this.counter_currency = counter_currency;
	}
	public Object getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Object brand_id) {
		this.brand_id = brand_id;
	}
	public int getShipping_amount() {
		return shipping_amount;
	}
	public void setShipping_amount(int shipping_amount) {
		this.shipping_amount = shipping_amount;
	}
	public String getBuild_version() {
		return build_version;
	}
	public void setBuild_version(String build_version) {
		this.build_version = build_version;
	}
	public Object getPos_id() {
		return pos_id;
	}
	public void setPos_id(Object pos_id) {
		this.pos_id = pos_id;
	}
	public Object getStore_id() {
		return store_id;
	}
	public void setStore_id(Object store_id) {
		this.store_id = store_id;
	}
	public Object getIntegrator_id() {
		return integrator_id;
	}
	public void setIntegrator_id(Object integrator_id) {
		this.integrator_id = integrator_id;
	}
	public Object getPlatform_id() {
		return platform_id;
	}
	public void setPlatform_id(Object platform_id) {
		this.platform_id = platform_id;
	}
	public Object getCorporation_id() {
		return corporation_id;
	}
	public void setCorporation_id(String corporation_id) {
		this.corporation_id = corporation_id;
	}
	public int getCollector_id() {
		return collector_id;
	}
	public void setCollector_id(int collector_id) {
		this.collector_id = collector_id;
	}
	public Payer getPayer() {
		return payer;
	}
	public void setPayer(Payer payer) {
		this.payer = payer;
	}
	public Object getMarketplace_owner() {
		return marketplace_owner;
	}
	public void setMarketplace_owner(Object marketplace_owner) {
		this.marketplace_owner = marketplace_owner;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	public AdditionalInfo getAdditional_info() {
		return additional_info;
	}
	public void setAdditional_info(AdditionalInfo additional_info) {
		this.additional_info = additional_info;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Object getExternal_reference() {
		return external_reference;
	}
	public void setExternal_reference(Object external_reference) {
		this.external_reference = external_reference;
	}
	public double getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public int getTransaction_amount_refunded() {
		return transaction_amount_refunded;
	}
	public void setTransaction_amount_refunded(int transaction_amount_refunded) {
		this.transaction_amount_refunded = transaction_amount_refunded;
	}
	public int getCoupon_amount() {
		return coupon_amount;
	}
	public void setCoupon_amount(int coupon_amount) {
		this.coupon_amount = coupon_amount;
	}
	public Object getDifferential_pricing_id() {
		return differential_pricing_id;
	}
	public void setDifferential_pricing_id(Object differential_pricing_id) {
		this.differential_pricing_id = differential_pricing_id;
	}
	public Object getDeduction_schema() {
		return deduction_schema;
	}
	public void setDeduction_schema(Object deduction_schema) {
		this.deduction_schema = deduction_schema;
	}
	public Object getCallback_url() {
		return callback_url;
	}
	public void setCallback_url(Object callback_url) {
		this.callback_url = callback_url;
	}
	public int getInstallments() {
		return installments;
	}
	public void setInstallments(int installments) {
		this.installments = installments;
	}
	public TransactionDetails getTransaction_details() {
		return transaction_details;
	}
	public void setTransaction_details(TransactionDetails transaction_details) {
		this.transaction_details = transaction_details;
	}
	public ArrayList<Object> getFee_details() {
		return fee_details;
	}
	public void setFee_details(ArrayList<Object> fee_details) {
		this.fee_details = fee_details;
	}
	public ArrayList<Object> getCharges_details() {
		return charges_details;
	}
	public void setCharges_details(ArrayList<Object> charges_details) {
		this.charges_details = charges_details;
	}
	public boolean isCaptured() {
		return captured;
	}
	public void setCaptured(boolean captured) {
		this.captured = captured;
	}
	public boolean isBinary_mode() {
		return binary_mode;
	}
	public void setBinary_mode(boolean binary_mode) {
		this.binary_mode = binary_mode;
	}
	public Object getCall_for_authorize_id() {
		return call_for_authorize_id;
	}
	public void setCall_for_authorize_id(Object call_for_authorize_id) {
		this.call_for_authorize_id = call_for_authorize_id;
	}
	public Object getStatement_descriptor() {
		return statement_descriptor;
	}
	public void setStatement_descriptor(Object statement_descriptor) {
		this.statement_descriptor = statement_descriptor;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public String getNotification_url() {
		return notification_url;
	}
	public void setNotification_url(String notification_url) {
		this.notification_url = notification_url;
	}
	public ArrayList<Object> getRefunds() {
		return refunds;
	}
	public void setRefunds(ArrayList<Object> refunds) {
		this.refunds = refunds;
	}
	public String getProcessing_mode() {
		return processing_mode;
	}
	public void setProcessing_mode(String processing_mode) {
		this.processing_mode = processing_mode;
	}
	public Object getMerchant_account_id() {
		return merchant_account_id;
	}
	public void setMerchant_account_id(Object merchant_account_id) {
		this.merchant_account_id = merchant_account_id;
	}
	public Object getMerchant_number() {
		return merchant_number;
	}
	public void setMerchant_number(Object merchant_number) {
		this.merchant_number = merchant_number;
	}
	public ArrayList<Object> getAcquirer_reconciliation() {
		return acquirer_reconciliation;
	}
	public void setAcquirer_reconciliation(ArrayList<Object> acquirer_reconciliation) {
		this.acquirer_reconciliation = acquirer_reconciliation;
	}
	public PointOfInteraction getPoint_of_interaction() {
		return point_of_interaction;
	}
	public void setPoint_of_interaction(PointOfInteraction point_of_interaction) {
		this.point_of_interaction = point_of_interaction;
	}
    
    

}
