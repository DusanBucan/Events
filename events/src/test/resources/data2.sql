INSERT INTO `test`.`user` (`id`, `email`, `name`, `password`, `phone`, `surname`, `user_role`, `username`, `verified`) VALUES ('1', 'mica97@email.com', 'Milica', '$2y$12$NAY37CbhtssuFTQSqwaVfOCGOcB.xKV.O4gutHFHBgdoiGcpSSxbq', '123456789', 'Travica', 'ROLE_ADMIN', 'milovica', b'1');
INSERT INTO `test`.`user` (`id`, `email`, `name`, `password`, `phone`, `surname`, `user_role`, `username`, `verified`) VALUES ('2', 'cupka2797@gmail.com', 'Milica', '$2y$12$NAY37CbhtssuFTQSqwaVfOCGOcB.xKV.O4gutHFHBgdoiGcpSSxbq', '123456789', 'Travica', 'ROLE_REGULAR', 'dusan', b'1');

INSERT INTO `test`.`place` (`id`, `address`, `latitude`, `longitude`, `name`) VALUES ('1', 'Sime Milosevica', '1', '1', 'Hala1');

INSERT INTO `test`.`hall` (`id`, `name`, `place_id`) VALUES ('1', 'sala1', '1');
INSERT INTO `test`.`hall` (`id`, `name`, `place_id`) VALUES ('2', 'sala2', '1');
INSERT INTO `test`.`hall` (`id`, `name`, `place_id`) VALUES ('3', 'sala3', '1');


INSERT INTO `test`.`sector` (`id`, `name`, `sector_columns`, `sector_rows`, `hall_id`) VALUES ('1', 'sektor1', '1', '1', '1');
INSERT INTO `test`.`sector` (`id`, `name`, `sector_columns`, `sector_rows`, `hall_id`) VALUES ('2', 'sektor2', '0', '0', '1');
INSERT INTO `test`.`sector` (`id`, `name`, `sector_columns`, `sector_rows`, `hall_id`) VALUES ('3', 'sektor3', '2', '1', '2');


INSERT INTO `test`.`seat` (`id`, `seat_column`, `seat_row`, `sector_id`) VALUES ('1', '1', '1', '1');
INSERT INTO `test`.`seat` (`id`, `seat_column`, `seat_row`, `sector_id`) VALUES ('2', '1', '1', '3');
INSERT INTO `test`.`seat` (`id`, `seat_column`, `seat_row`, `sector_id`) VALUES ('3', '2', '1', '3');

INSERT INTO `test`.`event` (`id`, `description`, `event_state`, `event_type`, `from_date`, `name`, `to_date`) VALUES ('1', 'dfa', 'AVAILABLE', 'SPORT', '2020-01-01', 'UTAKMICA1', '2020-01-02');
INSERT INTO `test`.`event` (`id`, `description`, `event_state`, `event_type`, `from_date`, `name`, `to_date`) VALUES ('2', 'dfa', 'CANCELED', 'SPORT', '2021-01-01', 'UTAKMICA3', '2021-01-02');
INSERT INTO `test`.`event` (`id`, `description`, `event_state`, `event_type`, `from_date`, `name`, `to_date`) VALUES ('3', 'dfa', 'AVAILABLE', 'OPERA', '2023-01-01', 'UTAKMICA2', '2023-01-02');
INSERT INTO `test`.`event` (`id`, `description`, `event_state`, `event_type`, `from_date`, `name`, `to_date`) VALUES ('4', 'dfa', 'AVAILABLE', 'SPORT', '2022-01-01', 'UTAKMICA4', '2022-01-02');
INSERT INTO `test`.`event` (`id`, `description`, `event_state`, `event_type`, `from_date`, `name`, `to_date`) VALUES ('5', 'dfa', 'FINISHED', 'SPORT', '2019-01-01', 'UTAKMICA5', '2019-01-01');


INSERT INTO `test`.`event_hall` (`event_id`, `hall_id`) VALUES ('1', '1');
INSERT INTO `test`.`event_hall` (`event_id`, `hall_id`) VALUES ('2', '1');
INSERT INTO `test`.`event_hall` (`event_id`, `hall_id`) VALUES ('3', '1');
INSERT INTO `test`.`event_hall` (`event_id`, `hall_id`) VALUES ('4', '1');
INSERT INTO `test`.`event_hall` (`event_id`, `hall_id`) VALUES ('5', '1');


INSERT INTO `test`.`ticket` (`id`, `bar_code`, `price`, `ticket_state`, `version`, `event_id`, `seat_id`) VALUES ('1', 'DFA', '100.00','AVAILABLE', '0', '1', '1');
INSERT INTO `test`.`ticket` (`id`, `bar_code`, `price`, `ticket_state`, `version`, `event_id`, `seat_id`, `user_id`) VALUES ('2', 'DFA', '100.00','BOUGHT', '0', '2', '1', '2');
INSERT INTO `test`.`ticket` (`id`, `bar_code`, `price`, `ticket_state`, `version`, `event_id`, `seat_id`) VALUES ('3', 'DFA', '200.00','AVAILABLE', '0', '2', '2');
INSERT INTO `test`.`ticket` (`id`, `bar_code`, `price`, `ticket_state`, `version`, `event_id`, `seat_id`,`user_id` ) VALUES ('4', 'DFA', '200.00','RESERVED', '0', '2', '1', '2');


INSERT INTO `test`.`media` (`id`, `path`, `event_id`) VALUES ('1', 'slicica','1');
INSERT INTO `test`.`media` (`id`, `path`, `event_id`) VALUES ('2', 'slicicaa','1');
INSERT INTO `test`.`media` (`id`, `path`, `event_id`) VALUES ('3', 'slicicaabrisanje','2');

INSERT INTO `test`.`price_list` (`id`, `price`, `event_id`, `sector_id`) VALUES ('1', '100','1', '1');
INSERT INTO `test`.`price_list` (`id`, `price`, `event_id`, `sector_id`) VALUES ('2', '100','1', '2');

INSERT INTO `test`.`sector_capacity` (`id`, `capacity`, `free`, `sector_id`) VALUES ('1', '100', '100', '1');
INSERT INTO `test`.`sector_capacity` (`id`, `capacity`, `free`, `sector_id`) VALUES ('2', '140', '140', '1');
INSERT INTO `test`.`sector_capacity` (`id`, `capacity`, `free`, `sector_id`) VALUES ('3', '110', '110', '1');
INSERT INTO `test`.`sector_capacity` (`id`, `capacity`, `free`, `sector_id`) VALUES ('4', '100', '100', '2');