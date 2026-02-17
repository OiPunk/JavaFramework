package com.mashibing.service;

import com.mashibing.dao.BookDao;
import com.mashibing.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    /*
     * propagation:translatedText：translatedText
     * isolation:translatedText：4translatedText，translatedText
     * timeout：translatedText,
     * readonly：translatedText:translatedText，translatedText，translatedText，translatedText
     *
     * translatedText
     * noRollBackfor: noRollbackFor = {ArithmeticException.class}
     * noRollbackForClassName:
     *
     * translatedText
     * rollBackfor:
     * rollbackForClassName
     * */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buyBook() {
        bookDao.getPrice(1);
        bookDao.updateBalance("zhangsan", 100);
        bookDao.updateStock(1);
        int i = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updatePrice() {
        bookDao.updatePrice(1);
//        int i = 1/0;
    }

    @Transactional
    public void mult() {
        buyBook();
        updatePrice();
    }
}
