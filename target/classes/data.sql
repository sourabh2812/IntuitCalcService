INSERT INTO asset_detail (asset_name, asset_value, asset_group_id)
VALUES ('Chequing', 2000, 1);
INSERT INTO asset_detail (asset_name, asset_value, asset_group_id)
VALUES ('Savings for Taxes', 4000, 1);
INSERT INTO asset_detail (asset_name, asset_value, asset_group_id)
VALUES ('Rainy Day Fund', 506, 1);
INSERT INTO asset_detail (asset_name, asset_value, asset_group_id)
VALUES ('Primary Home', 455000, 2);
INSERT INTO asset_detail (asset_name, asset_value, asset_group_id)
VALUES ('Secondary Home', 1564321, 2);

INSERT INTO liability_detail (liability_name, liability_value, liability_group_id)
VALUES ('Credit Card 1', 4342, 1);
INSERT INTO liability_detail (liability_name, liability_value, liability_group_id)
VALUES ('Credit Card 2', 322, 1);
INSERT INTO liability_detail (liability_name, liability_value, liability_group_id)
VALUES ('Mortgage 1', 250999, 2);
INSERT INTO liability_detail (liability_name, liability_value, liability_group_id)
VALUES ('Mortgage 2', 632634, 2);
INSERT INTO liability_detail (liability_name, liability_value, liability_group_id)
VALUES ('Line of Credit', 10000, 2);

INSERT INTO asset_group (asset_group_id, asset_group_name) VALUES (1, 'Cash and Investments');
INSERT INTO asset_group (asset_group_id, asset_group_name) VALUES (2, 'Long Term Assets');

INSERT INTO liability_group (liability_group_id, liability_group_name) VALUES (1, 'Short Term Liabilties');
INSERT INTO liability_group (liability_group_id, liability_group_name) VALUES (2, 'Long Term Debt');

INSERT INTO currency (currency_code, currency_value, selected_currency)
VALUES ('CAD', 1.36, false);
INSERT INTO currency (currency_code, currency_value, selected_currency)
VALUES ('USD', 1, true);
INSERT INTO currency (currency_code, currency_value, selected_currency)
VALUES ('INR', 76, false);