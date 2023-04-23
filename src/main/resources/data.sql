-- 테스트 계정
-- TODO: 테스트용이지만 비밀번호가 노출된 데이터 세팅. 개선하는 것이 좋을 지 고민해 보자.
insert into user_account (user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
('shw7349', '{noop}asdf1234', 'Songhw', 'shw7349@naver.com', 'I am Hyunwoo.', now(), 'Hyunwoo', now(), 'Hyunwoo')
;
insert into user_account (user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
('shw7549', '{noop}asdf1234', 'Songhw2', 'shw7549@naver.com', 'I am Hyunwoo2.', now(), 'Hyunwoo2', now(), 'Hyunwoo2')
;