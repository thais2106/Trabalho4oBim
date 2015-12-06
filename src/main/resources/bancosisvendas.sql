SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE DATABASE `sisvendas` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sisvendas`;

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL DEFAULT '0',
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `cliente` (`id`, `nome`, `telefone`, `endereco`, `cidade`, `uf`, `email`, `genero`) VALUES
(1, 'THAIS CRIVELATTI', '(45)9999-9999', 'RUA DAS FLORESsss', 'CASCAVEL', 'PR', 'THAIS@GMAIL.COM', 'Feminino'),
(2, 'PEDRO ALVARES CABRAL', '(11)8888-8888', 'RUA DAS CARAVELAS', 'SAO PAULO', 'SP', 'CABRAL@HOTMAIL.COM', 'Masculino'),
(3, 'ADA LOVELACE', '(45)3224-3333', 'RUA 10 DE DEZEMBRO', 'PALOTINA', 'PR', 'ADALUV@GMAIL.COM', 'Feminino'),
(4, 'PIKACHU', '9988-7766', 'ONDE O ASH ESTIVER', 'VERMILLION CITY', 'AC', 'THUNDERBOLT@GMAIL.COM', 'Masculino'),
(5, 'ALICE', '8877-4455', 'RUA DO CHAPELEIRO MALUCO', 'PAIS DAS MARAVILHAS', 'MG', 'ALICE@GMAIL.COM', 'Feminino'),
(6, 'JOAO DA SILVA', '8888-3344', 'RUA DO PATO MANCO', 'RIO DE JANEIRO', 'RJ', 'JOAO.SILVA@HOTMAIL.COM', 'Masculino'),
(7, 'EDSON ARANTES DO NASCIMENTO', '88774444', 'RUA DO PELE', 'SANTOS', 'SP', 'PELE@YAHOO.COM', 'Masculino');

CREATE TABLE IF NOT EXISTS `item` (
  `idvenda` int(11) NOT NULL DEFAULT '0',
  `idproduto` int(11) NOT NULL DEFAULT '0',
  `descricao` varchar(255) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `custo` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`idvenda`,`idproduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `item` (`idvenda`, `idproduto`, `descricao`, `quantidade`, `custo`) VALUES
(1, 1, 'ARROZ', 1, '7.50'),
(2, 1, 'ARROZ', 2, '7.50'),
(3, 2, 'VEJA MULTIUSO', 3, '5.50'),
(3, 3, 'SABONETE', 6, '3.00');

CREATE TABLE IF NOT EXISTS `produto` (
  `id` int(11) NOT NULL DEFAULT '0',
  `codbarras` varchar(255) DEFAULT NULL,
  `descricao` varchar(20) DEFAULT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `unidade` varchar(50) DEFAULT NULL,
  `custo` decimal(8,2) DEFAULT NULL,
  `margemlucro` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `produto` (`id`, `codbarras`, `descricao`, `categoria`, `unidade`, `custo`, `margemlucro`) VALUES
(1, '00110011', 'ARROZ', 'Alimentação', 'Kilo', '7.50', '10.00'),
(2, '00220022', 'VEJA MULTIUSO', 'Limpeza', 'Unidade', '5.50', '2.00'),
(3, '00330033', 'SABONETE', 'Higiene', 'Unidade', '3.00', '10.00'),
(4, '00440044', 'SHAMPOO', 'Higiene', 'Unidade', '9.90', '2.00');

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL DEFAULT '0',
  `idcliente` int(11) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `usuario` (`id`, `idcliente`, `senha`) VALUES
(1, 1, '1'),
(2, 3, 'ada'),
(3, 2, 'pedro'),
(4, 4, 'pikapi'),
(5, 5, 'ALICE');

CREATE TABLE IF NOT EXISTS `venda` (
  `idvenda` int(11) NOT NULL DEFAULT '0',
  `idcliente` int(11) DEFAULT NULL,
  `nomecliente` varchar(255) DEFAULT NULL,
  `valortotal` decimal(8,2) DEFAULT NULL,
  `valorpagamento` decimal(8,2) DEFAULT NULL,
  `datavenda` date DEFAULT NULL,
  `horavenda` time DEFAULT NULL,
  PRIMARY KEY (`idvenda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `venda` (`idvenda`, `idcliente`, `nomecliente`, `valortotal`, `valorpagamento`, `datavenda`, `horavenda`) VALUES
(1, 1, 'THAIS CRIVELATTI', '7.50', '8.00', '2015-12-04', '22:57:56'),
(2, 4, 'PIKACHU', '15.00', '20.00', '2015-12-04', '23:03:55'),
(3, 4, 'PIKACHU', '34.50', '50.00', '2015-12-05', '22:45:04');
