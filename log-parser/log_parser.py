import re

USER_LOG_PATTERN = r'(\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}) \| (.*)'
USER_FILENAME = "logs/users.log"

BOOK_LOG_PATTERN = r'(\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}) \| (.*)'
BOOK_FILENAME = "./logs/books.log"

def parse_line(log_pattern, line):
    match = re.match(log_pattern, line)
    if match:
        timestamp = match.group(1)
        message = match.group(2)
        return {'timestamp': timestamp, 'message': message}
    else:
        Exception("Incorrect logging pattern")

def parse_log_file(log_pattern, filename):
    with open(filename, "r") as file:
        parsed_logs = []
        for line in file:
            parsed_logs.append(parse_line(log_pattern, line))

        return parsed_logs #in format {'timestamp': 'YYYY-MM-DD HH:MM:SS', 'message': '...'}