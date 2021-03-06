package com.jian.entity;

import java.util.ArrayList;
import java.util.List;

public class LjClientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LjClientExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDeviceSerilIsNull() {
            addCriterion("device_seril is null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilIsNotNull() {
            addCriterion("device_seril is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilEqualTo(String value) {
            addCriterion("device_seril =", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilNotEqualTo(String value) {
            addCriterion("device_seril <>", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilGreaterThan(String value) {
            addCriterion("device_seril >", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilGreaterThanOrEqualTo(String value) {
            addCriterion("device_seril >=", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilLessThan(String value) {
            addCriterion("device_seril <", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilLessThanOrEqualTo(String value) {
            addCriterion("device_seril <=", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilLike(String value) {
            addCriterion("device_seril like", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilNotLike(String value) {
            addCriterion("device_seril not like", value, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilIn(List<String> values) {
            addCriterion("device_seril in", values, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilNotIn(List<String> values) {
            addCriterion("device_seril not in", values, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilBetween(String value1, String value2) {
            addCriterion("device_seril between", value1, value2, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilNotBetween(String value1, String value2) {
            addCriterion("device_seril not between", value1, value2, "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(Integer value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(Integer value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(Integer value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(Integer value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<Integer> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<Integer> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(Integer value1, Integer value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressIsNull() {
            addCriterion("device_address is null");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressIsNotNull() {
            addCriterion("device_address is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressEqualTo(String value) {
            addCriterion("device_address =", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotEqualTo(String value) {
            addCriterion("device_address <>", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressGreaterThan(String value) {
            addCriterion("device_address >", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressGreaterThanOrEqualTo(String value) {
            addCriterion("device_address >=", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLessThan(String value) {
            addCriterion("device_address <", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLessThanOrEqualTo(String value) {
            addCriterion("device_address <=", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLike(String value) {
            addCriterion("device_address like", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotLike(String value) {
            addCriterion("device_address not like", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressIn(List<String> values) {
            addCriterion("device_address in", values, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotIn(List<String> values) {
            addCriterion("device_address not in", values, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressBetween(String value1, String value2) {
            addCriterion("device_address between", value1, value2, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotBetween(String value1, String value2) {
            addCriterion("device_address not between", value1, value2, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyIsNull() {
            addCriterion("device_accuracy is null");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyIsNotNull() {
            addCriterion("device_accuracy is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyEqualTo(String value) {
            addCriterion("device_accuracy =", value, "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyNotEqualTo(String value) {
            addCriterion("device_accuracy <>", value, "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyGreaterThan(String value) {
            addCriterion("device_accuracy >", value, "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyGreaterThanOrEqualTo(String value) {
            addCriterion("device_accuracy >=", value, "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyLessThan(String value) {
            addCriterion("device_accuracy <", value, "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyLessThanOrEqualTo(String value) {
            addCriterion("device_accuracy <=", value, "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyLike(String value) {
            addCriterion("device_accuracy like", value, "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyNotLike(String value) {
            addCriterion("device_accuracy not like", value, "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyIn(List<String> values) {
            addCriterion("device_accuracy in", values, "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyNotIn(List<String> values) {
            addCriterion("device_accuracy not in", values, "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyBetween(String value1, String value2) {
            addCriterion("device_accuracy between", value1, value2, "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyNotBetween(String value1, String value2) {
            addCriterion("device_accuracy not between", value1, value2, "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andTcpIpIsNull() {
            addCriterion("tcp_ip is null");
            return (Criteria) this;
        }

        public Criteria andTcpIpIsNotNull() {
            addCriterion("tcp_ip is not null");
            return (Criteria) this;
        }

        public Criteria andTcpIpEqualTo(String value) {
            addCriterion("tcp_ip =", value, "tcpIp");
            return (Criteria) this;
        }

        public Criteria andTcpIpNotEqualTo(String value) {
            addCriterion("tcp_ip <>", value, "tcpIp");
            return (Criteria) this;
        }

        public Criteria andTcpIpGreaterThan(String value) {
            addCriterion("tcp_ip >", value, "tcpIp");
            return (Criteria) this;
        }

        public Criteria andTcpIpGreaterThanOrEqualTo(String value) {
            addCriterion("tcp_ip >=", value, "tcpIp");
            return (Criteria) this;
        }

        public Criteria andTcpIpLessThan(String value) {
            addCriterion("tcp_ip <", value, "tcpIp");
            return (Criteria) this;
        }

        public Criteria andTcpIpLessThanOrEqualTo(String value) {
            addCriterion("tcp_ip <=", value, "tcpIp");
            return (Criteria) this;
        }

        public Criteria andTcpIpLike(String value) {
            addCriterion("tcp_ip like", value, "tcpIp");
            return (Criteria) this;
        }

        public Criteria andTcpIpNotLike(String value) {
            addCriterion("tcp_ip not like", value, "tcpIp");
            return (Criteria) this;
        }

        public Criteria andTcpIpIn(List<String> values) {
            addCriterion("tcp_ip in", values, "tcpIp");
            return (Criteria) this;
        }

        public Criteria andTcpIpNotIn(List<String> values) {
            addCriterion("tcp_ip not in", values, "tcpIp");
            return (Criteria) this;
        }

        public Criteria andTcpIpBetween(String value1, String value2) {
            addCriterion("tcp_ip between", value1, value2, "tcpIp");
            return (Criteria) this;
        }

        public Criteria andTcpIpNotBetween(String value1, String value2) {
            addCriterion("tcp_ip not between", value1, value2, "tcpIp");
            return (Criteria) this;
        }

        public Criteria andTcpPortIsNull() {
            addCriterion("tcp_port is null");
            return (Criteria) this;
        }

        public Criteria andTcpPortIsNotNull() {
            addCriterion("tcp_port is not null");
            return (Criteria) this;
        }

        public Criteria andTcpPortEqualTo(Integer value) {
            addCriterion("tcp_port =", value, "tcpPort");
            return (Criteria) this;
        }

        public Criteria andTcpPortNotEqualTo(Integer value) {
            addCriterion("tcp_port <>", value, "tcpPort");
            return (Criteria) this;
        }

        public Criteria andTcpPortGreaterThan(Integer value) {
            addCriterion("tcp_port >", value, "tcpPort");
            return (Criteria) this;
        }

        public Criteria andTcpPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("tcp_port >=", value, "tcpPort");
            return (Criteria) this;
        }

        public Criteria andTcpPortLessThan(Integer value) {
            addCriterion("tcp_port <", value, "tcpPort");
            return (Criteria) this;
        }

        public Criteria andTcpPortLessThanOrEqualTo(Integer value) {
            addCriterion("tcp_port <=", value, "tcpPort");
            return (Criteria) this;
        }

        public Criteria andTcpPortIn(List<Integer> values) {
            addCriterion("tcp_port in", values, "tcpPort");
            return (Criteria) this;
        }

        public Criteria andTcpPortNotIn(List<Integer> values) {
            addCriterion("tcp_port not in", values, "tcpPort");
            return (Criteria) this;
        }

        public Criteria andTcpPortBetween(Integer value1, Integer value2) {
            addCriterion("tcp_port between", value1, value2, "tcpPort");
            return (Criteria) this;
        }

        public Criteria andTcpPortNotBetween(Integer value1, Integer value2) {
            addCriterion("tcp_port not between", value1, value2, "tcpPort");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNull() {
            addCriterion("merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(String value) {
            addCriterion("merchant_id =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(String value) {
            addCriterion("merchant_id <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(String value) {
            addCriterion("merchant_id >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_id >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(String value) {
            addCriterion("merchant_id <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("merchant_id <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLike(String value) {
            addCriterion("merchant_id like", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotLike(String value) {
            addCriterion("merchant_id not like", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<String> values) {
            addCriterion("merchant_id in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<String> values) {
            addCriterion("merchant_id not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(String value1, String value2) {
            addCriterion("merchant_id between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(String value1, String value2) {
            addCriterion("merchant_id not between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andDeviceSerilLikeInsensitive(String value) {
            addCriterion("upper(device_seril) like", value.toUpperCase(), "deviceSeril");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLikeInsensitive(String value) {
            addCriterion("upper(device_name) like", value.toUpperCase(), "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLikeInsensitive(String value) {
            addCriterion("upper(device_address) like", value.toUpperCase(), "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAccuracyLikeInsensitive(String value) {
            addCriterion("upper(device_accuracy) like", value.toUpperCase(), "deviceAccuracy");
            return (Criteria) this;
        }

        public Criteria andTcpIpLikeInsensitive(String value) {
            addCriterion("upper(tcp_ip) like", value.toUpperCase(), "tcpIp");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLikeInsensitive(String value) {
            addCriterion("upper(merchant_id) like", value.toUpperCase(), "merchantId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}