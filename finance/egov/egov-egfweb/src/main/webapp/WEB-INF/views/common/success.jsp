<%@ page contentType="text/html" language="java"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row printable">
    <div class="col-md-12">
        <div class="panel panel-primary" data-collapsed="0"
             style="text-align: left">
            <div class="panel-heading">
                <div class="panel-title">
                    <div align="center">
                        <span>Success !</span>
                    </div>

                </div>
            </div>
            <div class="panel-body">
                <div align="center" style="font-size: 16px;">
                    <span  > ${message} </span>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12 text-center">
            <button type="button" class="btn btn-default" id="button2"
                    onclick="window.close();">
                <spring:message code="lbl.close" />
            </button>
        </div>
    </div>
</div>