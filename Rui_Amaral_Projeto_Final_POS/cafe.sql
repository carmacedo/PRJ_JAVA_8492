-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14-Maio-2023 às 04:49
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `cafe`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `fatura`
--

CREATE TABLE `fatura` (
  `id` int(50) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `NIF` varchar(15) NOT NULL,
  `IVA` varchar(15) DEFAULT NULL,
  `Total_Fatura` varchar(50) DEFAULT NULL,
  `Data_Fatura` varchar(50) DEFAULT NULL,
  `Pagamento` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `fatura`
--

INSERT INTO `fatura` (`id`, `Nome`, `NIF`, `IVA`, `Total_Fatura`, `Data_Fatura`, `Pagamento`) VALUES
(1, 'Rui Amaral', '213456789', '1,77', '9,00', '11-05-2023', 'Cash'),
(2, 'Rui Miguel', '211111111', '1,94', '10,30', '11-05-2023', 'Multi'),
(3, 'Gustavo', '211111111', '3,49', '25,30', '11-05-2023', 'Master'),
(4, 'Iris', '211115462', '1,35', '6,50', '11-05-2023', 'Visa'),
(5, 'Iris Amaral', '21999999', '1,57', '10,50', '11-05-2023', 'Cash'),
(6, 'Gustavo Rafael', '21888888', '3,48', '19,50', '11-05-2023', 'Visa'),
(7, 'Gustavo', '211111111', '-3.49', '-25.3', '11-05-2023', 'Master(Void FT 3)'),
(8, 'testes', '999888777', '4,14', '18,00', '11-05-2023', 'Master'),
(9, 'Antonio Alberto', '789465123', '4,68', '21,00', '14-05-2023', 'Multi'),
(10, 'afonso', '456789123', '1,38', '6,00', '14-05-2023', 'Visa');

-- --------------------------------------------------------

--
-- Estrutura da tabela `stocks`
--

CREATE TABLE `stocks` (
  `id` int(5) NOT NULL,
  `nomeproduto` varchar(15) DEFAULT NULL,
  `precoproduto` double DEFAULT NULL,
  `IVA` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `stocks`
--

INSERT INTO `stocks` (`id`, `nomeproduto`, `precoproduto`, `IVA`) VALUES
(1, 'Sangria', 8, 23),
(2, 'Gelado 2 Bolas', 3.5, 23),
(3, 'Vinho Copo', 2, 23),
(4, 'Caipirinha', 5, 23),
(5, 'Fanta Laranja', 2, 23),
(6, 'Pastel de Nata', 1.5, 13),
(8, 'CocaCola', 5, 23),
(9, 'Fanta', 5, 23),
(10, 'Sumol', 1.5, 23),
(14, 'HotDog', 3.5, 13);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `fatura`
--
ALTER TABLE `fatura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Índices para tabela `stocks`
--
ALTER TABLE `stocks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `fatura`
--
ALTER TABLE `fatura`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `stocks`
--
ALTER TABLE `stocks`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
