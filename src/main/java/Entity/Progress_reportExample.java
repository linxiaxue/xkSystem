package Entity;

import java.util.ArrayList;
import java.util.List;

public class Progress_reportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Progress_reportExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStudentNoIsNull() {
            addCriterion("student_no is null");
            return (Criteria) this;
        }

        public Criteria andStudentNoIsNotNull() {
            addCriterion("student_no is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNoEqualTo(String value) {
            addCriterion("student_no =", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotEqualTo(String value) {
            addCriterion("student_no <>", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoGreaterThan(String value) {
            addCriterion("student_no >", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoGreaterThanOrEqualTo(String value) {
            addCriterion("student_no >=", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLessThan(String value) {
            addCriterion("student_no <", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLessThanOrEqualTo(String value) {
            addCriterion("student_no <=", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLike(String value) {
            addCriterion("student_no like", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotLike(String value) {
            addCriterion("student_no not like", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoIn(List<String> values) {
            addCriterion("student_no in", values, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotIn(List<String> values) {
            addCriterion("student_no not in", values, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoBetween(String value1, String value2) {
            addCriterion("student_no between", value1, value2, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotBetween(String value1, String value2) {
            addCriterion("student_no not between", value1, value2, "studentNo");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNull() {
            addCriterion("plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(Integer value) {
            addCriterion("plan_id =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(Integer value) {
            addCriterion("plan_id <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(Integer value) {
            addCriterion("plan_id >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_id >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(Integer value) {
            addCriterion("plan_id <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("plan_id <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<Integer> values) {
            addCriterion("plan_id in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<Integer> values) {
            addCriterion("plan_id not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(Integer value1, Integer value2) {
            addCriterion("plan_id between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_id not between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeIsNull() {
            addCriterion("plan_section_type is null");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeIsNotNull() {
            addCriterion("plan_section_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeEqualTo(String value) {
            addCriterion("plan_section_type =", value, "planSectionType");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeNotEqualTo(String value) {
            addCriterion("plan_section_type <>", value, "planSectionType");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeGreaterThan(String value) {
            addCriterion("plan_section_type >", value, "planSectionType");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_section_type >=", value, "planSectionType");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeLessThan(String value) {
            addCriterion("plan_section_type <", value, "planSectionType");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeLessThanOrEqualTo(String value) {
            addCriterion("plan_section_type <=", value, "planSectionType");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeLike(String value) {
            addCriterion("plan_section_type like", value, "planSectionType");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeNotLike(String value) {
            addCriterion("plan_section_type not like", value, "planSectionType");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeIn(List<String> values) {
            addCriterion("plan_section_type in", values, "planSectionType");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeNotIn(List<String> values) {
            addCriterion("plan_section_type not in", values, "planSectionType");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeBetween(String value1, String value2) {
            addCriterion("plan_section_type between", value1, value2, "planSectionType");
            return (Criteria) this;
        }

        public Criteria andPlanSectionTypeNotBetween(String value1, String value2) {
            addCriterion("plan_section_type not between", value1, value2, "planSectionType");
            return (Criteria) this;
        }

        public Criteria andPlanThresholdIsNull() {
            addCriterion("plan_threshold is null");
            return (Criteria) this;
        }

        public Criteria andPlanThresholdIsNotNull() {
            addCriterion("plan_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andPlanThresholdEqualTo(Integer value) {
            addCriterion("plan_threshold =", value, "planThreshold");
            return (Criteria) this;
        }

        public Criteria andPlanThresholdNotEqualTo(Integer value) {
            addCriterion("plan_threshold <>", value, "planThreshold");
            return (Criteria) this;
        }

        public Criteria andPlanThresholdGreaterThan(Integer value) {
            addCriterion("plan_threshold >", value, "planThreshold");
            return (Criteria) this;
        }

        public Criteria andPlanThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_threshold >=", value, "planThreshold");
            return (Criteria) this;
        }

        public Criteria andPlanThresholdLessThan(Integer value) {
            addCriterion("plan_threshold <", value, "planThreshold");
            return (Criteria) this;
        }

        public Criteria andPlanThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("plan_threshold <=", value, "planThreshold");
            return (Criteria) this;
        }

        public Criteria andPlanThresholdIn(List<Integer> values) {
            addCriterion("plan_threshold in", values, "planThreshold");
            return (Criteria) this;
        }

        public Criteria andPlanThresholdNotIn(List<Integer> values) {
            addCriterion("plan_threshold not in", values, "planThreshold");
            return (Criteria) this;
        }

        public Criteria andPlanThresholdBetween(Integer value1, Integer value2) {
            addCriterion("plan_threshold between", value1, value2, "planThreshold");
            return (Criteria) this;
        }

        public Criteria andPlanThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_threshold not between", value1, value2, "planThreshold");
            return (Criteria) this;
        }

        public Criteria andActualcreditIsNull() {
            addCriterion("actualCredit is null");
            return (Criteria) this;
        }

        public Criteria andActualcreditIsNotNull() {
            addCriterion("actualCredit is not null");
            return (Criteria) this;
        }

        public Criteria andActualcreditEqualTo(Integer value) {
            addCriterion("actualCredit =", value, "actualcredit");
            return (Criteria) this;
        }

        public Criteria andActualcreditNotEqualTo(Integer value) {
            addCriterion("actualCredit <>", value, "actualcredit");
            return (Criteria) this;
        }

        public Criteria andActualcreditGreaterThan(Integer value) {
            addCriterion("actualCredit >", value, "actualcredit");
            return (Criteria) this;
        }

        public Criteria andActualcreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("actualCredit >=", value, "actualcredit");
            return (Criteria) this;
        }

        public Criteria andActualcreditLessThan(Integer value) {
            addCriterion("actualCredit <", value, "actualcredit");
            return (Criteria) this;
        }

        public Criteria andActualcreditLessThanOrEqualTo(Integer value) {
            addCriterion("actualCredit <=", value, "actualcredit");
            return (Criteria) this;
        }

        public Criteria andActualcreditIn(List<Integer> values) {
            addCriterion("actualCredit in", values, "actualcredit");
            return (Criteria) this;
        }

        public Criteria andActualcreditNotIn(List<Integer> values) {
            addCriterion("actualCredit not in", values, "actualcredit");
            return (Criteria) this;
        }

        public Criteria andActualcreditBetween(Integer value1, Integer value2) {
            addCriterion("actualCredit between", value1, value2, "actualcredit");
            return (Criteria) this;
        }

        public Criteria andActualcreditNotBetween(Integer value1, Integer value2) {
            addCriterion("actualCredit not between", value1, value2, "actualcredit");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(Integer value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(Integer value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(Integer value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(Integer value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(Integer value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<Integer> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<Integer> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(Integer value1, Integer value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andActualnumberIsNull() {
            addCriterion("actualNumber is null");
            return (Criteria) this;
        }

        public Criteria andActualnumberIsNotNull() {
            addCriterion("actualNumber is not null");
            return (Criteria) this;
        }

        public Criteria andActualnumberEqualTo(Integer value) {
            addCriterion("actualNumber =", value, "actualnumber");
            return (Criteria) this;
        }

        public Criteria andActualnumberNotEqualTo(Integer value) {
            addCriterion("actualNumber <>", value, "actualnumber");
            return (Criteria) this;
        }

        public Criteria andActualnumberGreaterThan(Integer value) {
            addCriterion("actualNumber >", value, "actualnumber");
            return (Criteria) this;
        }

        public Criteria andActualnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("actualNumber >=", value, "actualnumber");
            return (Criteria) this;
        }

        public Criteria andActualnumberLessThan(Integer value) {
            addCriterion("actualNumber <", value, "actualnumber");
            return (Criteria) this;
        }

        public Criteria andActualnumberLessThanOrEqualTo(Integer value) {
            addCriterion("actualNumber <=", value, "actualnumber");
            return (Criteria) this;
        }

        public Criteria andActualnumberIn(List<Integer> values) {
            addCriterion("actualNumber in", values, "actualnumber");
            return (Criteria) this;
        }

        public Criteria andActualnumberNotIn(List<Integer> values) {
            addCriterion("actualNumber not in", values, "actualnumber");
            return (Criteria) this;
        }

        public Criteria andActualnumberBetween(Integer value1, Integer value2) {
            addCriterion("actualNumber between", value1, value2, "actualnumber");
            return (Criteria) this;
        }

        public Criteria andActualnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("actualNumber not between", value1, value2, "actualnumber");
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