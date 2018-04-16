# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from urlparse import urlparse
from .models import Text
from .forms import TextForm

from django.shortcuts import render

# Create your views here.

def read_url(request, param):


    url = request.get_full_path()
    parse_object = urlparse(url)
    string = parse_object.path[9:]
    newstring = "";
    if "//" not in string:
        newstring = string.replace("/", "***")
        data = {
        'text': newstring,
       }

        form = TextForm(data)
        if form.is_valid():
            form.save(commit = True)


    strings = Text.objects.all()
    return render(request, 'index.html', {'strings': strings })

def index(request):
    return render(request, 'index.html')
