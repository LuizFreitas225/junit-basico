package br.com.alura.tdd.service;


import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class BonusServiceTest {
    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();

        Assertions.assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(
                new Funcionario("Nicolau", LocalDate.now(), new BigDecimal("25000"))));

    }

    @Test
    void bonusDeveriaSer10PorCentoDeSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Nicolau", LocalDate.now(), new BigDecimal("2500")));

        Assertions.assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    void bonusNaoDeveZeraComBonusMaximo() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Nicolau", LocalDate.now(), new BigDecimal("10000")));

        Assertions.assertEquals(new BigDecimal("1000.0"), bonus);
    }
}