package com.ust.dsms.billing.function;

import com.ust.dsms.billing.rules.service.RuleService;
import java.util.Map;

public class FunctionAdd extends BaseFunction {

    private String leftOpernad;
    private String rightOpernad;

    @Override
    public void execute(RuleService ruleService, Map<String, Object> data) {
        Object leftOpernadValue = ruleService.get(leftOpernad, data);

        ruleService.lock(rightOpernad, data);
        if (leftOpernadValue instanceof Double) {
            Double rightOpernadValue = 0.0;
            if (ruleService.variableExist(rightOpernad, data)) {
                rightOpernadValue = (Double) ruleService.get(rightOpernad, data);
            }
            double result = (Double) leftOpernadValue + rightOpernadValue;
            ruleService.set(rightOpernad, result, data);
        }

    }

    public FunctionAdd(String leftOpernad, String rightOpernad, int index) {
        super(index);
        this.leftOpernad = leftOpernad;
        this.rightOpernad = rightOpernad;
    }

    public String getLeftOpernad() {
        return leftOpernad;
    }

    public void setLeftOpernad(String leftOpernad) {
        this.leftOpernad = leftOpernad;
    }

    public String getRightOpernad() {
        return rightOpernad;
    }

    public void setRightOpernad(String rightOpernad) {
        this.rightOpernad = rightOpernad;
    }

    @Override
    public String toString() {
        return "FunctionAdd [leftOpernad=" + leftOpernad + ", rightOpernad=" + rightOpernad + "]";
    }

}
