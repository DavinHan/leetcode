package com.hyun.demo.business.manufacturers.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class BookPo implements Serializable {

    private String bookName;
    private String borrowName;
    private Date borrowTime;

}
