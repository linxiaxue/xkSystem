package Dto;

import lombok.Data;

@Data
public class ReportDto {
    private String studentNo;

    private Integer planId;

    private String planSectionType;

    private Integer planThreshold;

    private Integer actual;

    private Integer unit;

    private String remark;
}
