package com.rainite.ad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_creative")
public class Creative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    //由运用程序去维护外键，企业开发中不建议在表中定义外键，1占用空间 2与母表耦合性强 3不好维护
    private String name;

    @Basic
    @Column(name = "type", nullable = false)
    private Integer type;

    // 物料类型，比如图片可以是bmp, jpg
    @Basic
    @Column(name = "material_type", nullable = false)
    private Integer materialType;

    @Basic
    @Column(name = "height", nullable = false)
    private Integer height;

    @Basic
    @Column(name = "width", nullable = false)
    private Integer width;

    //  物料大小
    @Basic
    @Column(name = "size", nullable = false)
    private Long size;

    // 持续时长，只有视频不为0
    @Basic
    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Basic
    @Column(name = "audit_status", nullable = false)
    private Integer auditStatus;

    @Basic
    @Column(name = "url", nullable = false)
    private String url;

    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Basic
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

}
